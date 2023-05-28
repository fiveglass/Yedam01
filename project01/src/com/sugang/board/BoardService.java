package com.sugang.board;

import java.util.List;
import java.util.Scanner;

import com.sugang.manager.ManagerDAO;
import com.sugang.member.MemberService;
import com.sugang.utils.pageMenu;

public class BoardService {
	
	pageMenu pm = new pageMenu();
	Board board = new Board();
	
	Scanner sc = new Scanner(System.in);
	
	private int page = 1;
	
	public BoardService() {
		
	}
	
	
	//회원게시판 : 목록
	public void memberBoardList() {
		String plusQuery = "board";
		int count = ManagerDAO.getInstance().getCount(plusQuery);
		
		int lastPage = count/5;
		lastPage = count%5 > 0 ? lastPage+1 : lastPage;
		if(page == 0) {
			page = 1;
			return;
		}
		
		List<Board> list = BoardDAO.getInstance().memberBoardList(page);
		System.out.printf("🚻 회원게시판 : 총 %d 건\n", count);
		System.out.println("============================================================================================");
		if (list.size() == 0) {
			System.out.println("| 정보가 입력이 되어 있지 않습니다.");
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.print((i+1) + "\t");
				System.out.print("| 글번호 : " + list.get(i).getBoardNo() + "\t");
				System.out.print("| 제목 : " + list.get(i).getBoardTitle() + "\t");
				System.out.print("| 작성자 : " + list.get(i).getMemberId() + "\t");
				System.out.println("| " + list.get(i).getBoardDate());
			}
			System.out.println("============================================================================================");
			System.out.printf("                   %d/%d pages\n" , page, lastPage);
			
			page = pageMenu.getPageBoardMenu(page, sc, plusQuery);
			memberBoardList();
		}
	}
	
	//회원게시판 : 글쓰기
	public void writeBoard() {
		System.out.println("📝글쓰기");
		
		System.out.println("작성자 : " + MemberService.memberInfo.getMemberId());
		board.setMemberId(MemberService.memberInfo.getMemberId());
		
		System.out.print("제목 : ");
		board.setBoardTitle(sc.nextLine());
		
		System.out.println("내용 : ");
		board.setBoardContent(sc.nextLine());
		
		int result = BoardDAO.getInstance().writeBoard(board);
		
		if(result > 0) {
			System.out.println("📨게시글이 등록되었습니다.");
		}else {
			System.out.println("게시글 등록이 실패하였습니다.");
		}
		memberBoardList();
	}
	
	//회원게시판 : 상세글보기 - 수정
	public void modifyBoard(int boardNo) {
		
		Board bd = BoardDAO.getInstance().checkMemberId(boardNo);
		if(bd.getMemberId().equals(MemberService.memberInfo.getMemberId())) {
			System.out.println("제목을 변경하시겠습니까?");
			System.out.println("1.예 / 2.아니요");
			int selectNo = Integer.parseInt(sc.nextLine());
			if(selectNo == 1) {
				System.out.println("변경하실 제목을 입력해주세요.");
				board.setBoardTitle(sc.nextLine());
				
				int result = BoardDAO.getInstance().modifyTitle(board, boardNo);
				if(result > 0) {
					System.out.println("👌 제목이 변경되었습니다.");
				}else {
					System.out.println("🤞 제목 변경이 실패하였습니다.");
				}
			}
			System.out.println("내용을 변경하시겠습니까?");
			System.out.println("1.예 / 2.아니요");
			selectNo = Integer.parseInt(sc.nextLine());
			if(selectNo == 1) {
				System.out.println("변경하실 내용을 입력해주세요.");
				board.setBoardContent(sc.nextLine());
				
				int result = BoardDAO.getInstance().modifyContent(board, boardNo);
				if(result > 0) {
					System.out.println("👌 내용이 변경되었습니다.");
				}else {
					System.out.println("🤞 내용 변경이 실패하였습니다.");
				}
			}
		}else {
			System.out.println("\n📌본인의 글만 수정 가능 합니다./n");
		}
		pm.boardDetail(boardNo, sc);
	}
	
	//회원게시판 : 상세글보기 - 삭제
	public void deleteBoard(int boardNo) {
		
		Board bd = BoardDAO.getInstance().checkMemberId(boardNo);
		if(bd.getMemberId().equals(MemberService.memberInfo.getMemberId())) {
			System.out.println("정말 삭제하시겠습니까? 1. 삭제 / 2. 뒤로가기");
			int selectNo = Integer.parseInt(sc.nextLine());
			if(selectNo == 1) {
				int result = BoardDAO.getInstance().deleteBoard(boardNo);
				if(result > 0) {
					System.out.println("👌 게시글이 삭제되었습니다.");
				}else {
					System.out.println("🤞 게시글 삭제 실패하였습니다.");
				}
			}else {
				return;
			}
		} else {
			System.out.println("\n📌본인의 글만 삭제 가능 합니다.\n");
		}
		memberBoardList();
	}
	
	//회원게시판 관리 : 목록
	public void managerBoardList() {
		String plusQuery = "board";
		int count = ManagerDAO.getInstance().getCount(plusQuery);
		
		int lastPage = count/5;
		lastPage = count%5 > 0 ? lastPage+1 : lastPage;
		if(page == 0) {
			page = 1;
			return;
		}
		
		List<Board> list = BoardDAO.getInstance().memberBoardList(page);
		System.out.printf("🚻 회원게시판 : 총 %d 건\n", count);
		System.out.println("============================================================================================");
		if (list.size() == 0) {
			System.out.println("| 정보가 입력이 되어 있지 않습니다.");
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.print((i+1) + "\t");
				System.out.print("| 글번호 : " + list.get(i).getBoardNo() + "\t");
				System.out.print("| 제목 : " + list.get(i).getBoardTitle() + "\t");
				System.out.print("| 작성자 : " + list.get(i).getMemberId() + "\t");
				System.out.println("| " + list.get(i).getBoardDate());
			}
			System.out.println("============================================================================================");
			System.out.printf("                   %d/%d pages\n" , page, lastPage);
			
			page = pageMenu.getPageBoardManagerMenu(page, sc, plusQuery);
			memberBoardList();
		}
	}
	
	//회원게시판 : 상세글보기 - 삭제
	public void deleteBoardmanager(int boardNo) {
		Board bd = BoardDAO.getInstance().checkMemberId(boardNo);
		System.out.println("정말 삭제하시겠습니까? 1. 삭제 / 2. 뒤로가기");
		int selectNo = Integer.parseInt(sc.nextLine());
		if(selectNo == 1) {
			int result = BoardDAO.getInstance().deleteBoard(boardNo);
			if(result > 0) {
				System.out.println("👌 게시글이 삭제되었습니다.");
			}else {
				System.out.println("🤞 게시글 삭제 실패하였습니다.");
			}
		}else {
			return;
		}
		memberBoardList();
	}
	
	//회원게시판 : 상세글보기 & 댓글조회
	public void replyList(int boardNo) {
		List<Board> list = BoardDAO.getInstance().replyList(boardNo);
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).getParentNo()==list.get(i).getReplyNo()) {
				System.out.print("L\t" + (i+1) + ". ");
			}else {
				System.out.print("LL\t" + (i+1) + ". ");
			}
			System.out.print(list.get(i).getReplyContent() + "\t");
			System.out.print("| 작성자 : " + list.get(i).getMemberId() + "\t");
			System.out.println("| 작성일 : " + list.get(i).getReplydate());
		}
	}
	
	//회원게시판 : 상세글보기 & 댓글조회 - 댓글작성
	public void writeReply(int boardNo) {
		System.out.println("댓글 내용>");
		board.setReplyContent(sc.nextLine());
		board.setBoardNo(boardNo);
		
		int result = BoardDAO.getInstance().writeReply(board);
		if(result > 0) {
			System.out.println("👌 댓글이 등록되었습니다.");
		}else {
			System.out.println("🤞 댓글 등록이 실패하였습니다.");
		}
		pm.boardDetail(boardNo, sc);
	}
	
	//회원게시판 : 상세글보기 & 댓글조회 - 대댓글작성
	public void writeRereply(int boardNo) {
		List<Board> list = BoardDAO.getInstance().replyList(boardNo);
		System.out.println("대댓글을 달아줄 댓글 번호를 입력해주세요.");
		int reply = Integer.parseInt(sc.nextLine())-1;
		Board selectedBoard = list.get(reply);
		if(selectedBoard.getParentNo() == selectedBoard.getReplyNo()) {
			System.out.println("대댓글 내용>");
			board.setReplyContent(sc.nextLine());
			board.setBoardNo(boardNo);
			board.setParentNo(selectedBoard.getReplyNo());
			
			int result = BoardDAO.getInstance().writeRereply(board);
			if(result > 0) {
				System.out.println("👌 댓글이 등록되었습니다.");
			}else {
				System.out.println("🤞 댓글 등록이 실패하였습니다.");
			}
		} else {
			System.out.println("대댓글에는 더이상 댓글을 달 수 없습니다.");
		}
		pm.boardDetail(boardNo, sc);
	}
	
}
