package com.sugang.utils;

import java.util.Scanner;

import com.sugang.board.Board;
import com.sugang.board.BoardDAO;
import com.sugang.board.BoardService;
import com.sugang.clas.Clas;
import com.sugang.clas.ClassDAO;
import com.sugang.manager.ManagerDAO;
import com.sugang.manager.ManagerService;

public class pageMenu {
	
	static BoardService bs = new BoardService();
	static ManagerService mns = new ManagerService();

	public static int getPageMenu(int page, Scanner sc, String tableName) {
		int returnPage;
		
		while(true) {
			int menu = inputMemberListMenu(sc);
			
			switch(menu) {
			case 1 :
				returnPage = movePrevList(page);
				return returnPage;
			case 2 :
				returnPage = moveNextList(page, tableName);
				return returnPage;
			case 3 :
				return 0;
			default : 
				System.out.println("없는 메뉴입니다.");
				break;
			}
		
		}
	}
	
	//회원조회 : 전체조회 페이지메뉴
	public static int inputMemberListMenu(Scanner sc) {
		System.out.printf("                   1.이전 / 2.다음 / 3.뒤로가기");
		int menu = Integer.parseInt(sc.nextLine());
		
		return menu;
	}
	
	public static int movePrevList(int page) {
		if(page == 1) {
			System.out.println("=====================");
			System.out.println("이전페이지가 존재하지 않습니다.");
			System.out.println("=====================");
		}else {
			page--;
		}
		return page;
		
	}

	public static int moveNextList(int page, String tableName) {
		int count = ManagerDAO.getInstance().getCount(tableName);
		int lastPage = count/5;
		lastPage = count%5 > 0 ? lastPage+1 : lastPage;
		if(page == lastPage) {
			System.out.println("=====================");
			System.out.println("다음페이지가 존재하지 않습니다.");
			System.out.println("=====================");
		}else {
			page++;	
		}
		return page;
	}

	
	//강의조회 : 강의목록 상세조회 메뉴
	public static int getPageMenu2(int page, Scanner sc, String tableName) {
		int returnPage;
		
		while(true) {
			int menu = inputMemberListMenu2(sc);
			
			switch(menu) {
			case 1 :
				returnPage = movePrevList(page);
				return returnPage;
			case 2 :
				returnPage = moveNextList(page, tableName);
				return returnPage;
			case 3 :
				System.out.println("============================================================================================");
				System.out.println("🔎 강의 내용을 확인하고 싶다면 강좌번호를 입력해주세요");
				int classno = Integer.parseInt(sc.nextLine());
				Clas cs = ClassDAO.getInstance().indexContent(classno);
				if(cs != null) {
					System.out.println("🔎" + cs.getClassName() + "'의 강의 내용");
					System.out.println(cs.getClassExplain());
				}else {
					System.out.println("조회정보없음");
				}	
				break;
			case 4 :
				return 0;
			default : 
				System.out.println("없는 메뉴입니다.");
				break;
			}
		
		}
	}
	
	//회원조회 : 전체조회 페이지메뉴
	public static int inputMemberListMenu2(Scanner sc) {
		System.out.printf("            1.이전 / 2.다음 / 3.상세내용검색 / 4.뒤로가기");
		int menu = Integer.parseInt(sc.nextLine());
		
		return menu;
	}
	
	//회원게시판 조회 메뉴
		public static int getPageBoardMenu(int page, Scanner sc, String tableName) {
			int returnPage;
			
			while(true) {
				int menu = inputBoardListMenu(sc);
				
				switch(menu) {
				case 1 :
					returnPage = movePrevList(page);
					return returnPage;
				case 2 :
					returnPage = moveNextList(page, tableName);
					return returnPage;
				case 3 :
					System.out.println("============================================================================================");
					System.out.println("🔎 내용을 확인하고 싶은 글번호를 입력하세요.");
					int boardNo = Integer.parseInt(sc.nextLine());
					boardDetail(boardNo, sc);
					break;
				case 4 :
					bs.writeBoard();
				default : 
					System.out.println("없는 메뉴입니다.");
					break;
				}
			
			}
		}
		
		//회원게시글 - 상세보기
		public static void boardDetail(int boardNo, Scanner sc) {
			Board bd = BoardDAO.getInstance().memberBoardContent(boardNo);
			if(bd != null) {
				System.out.print("📭 제목 : "+ bd.getBoardTitle() + "\t\t");
				System.out.print("작성자 : " + bd.getMemberId() + "\t");
				System.out.println("작성일 : " + bd.getBoardDate());
				System.out.println("============================================================================================");
				System.out.println("✏내용");
				System.out.println(bd.getBoardContent());
				System.out.println("--------------------------------------------------------------------------------------------");
				System.out.println("✉댓글내용");
				bs.replyList(boardNo);
				System.out.println("--------------------------------------------------------------------------------------------");
				int menu = inputContentListMenu(sc);
				if(menu == 1) {
					bs.writeReply(boardNo); //댓글
				}else if(menu == 2) {
					bs.writeRereply(boardNo);//대댓글
				}else if(menu == 3) {
					bs.modifyBoard(boardNo); //수정
				}else if(menu == 4){
					bs.deleteBoard(boardNo); //삭제
				}else {
					bs.memberBoardList(); //뒤로가기
				}
			}else {
				System.out.println("조회정보없음");
			}	
		}
		
		//회원게시판 조회 페이지메뉴
		public static int inputBoardListMenu(Scanner sc) {
			System.out.printf("1.이전 / 2.다음 / 3.상세글보기 / 4.글쓰기 / 5.뒤로가기");
			int menu = Integer.parseInt(sc.nextLine());
			
			return menu;
		}
		
		//회원게시판 : 상세조회 페이지메뉴
		public static int inputContentListMenu(Scanner sc) {
			System.out.printf("1.댓글쓰기 / 2.대댓글쓰기 / 3.수정 / 4.삭제 / 5.뒤로가기");
			int menu = Integer.parseInt(sc.nextLine());
			
			return menu;
		}
	
		//회원게시판 관리 조회 메뉴
		public static int getPageBoardManagerMenu(int page, Scanner sc, String tableName) {
			int returnPage;
			
			while(true) {
				int menu = inputBoardListManagerMenu(sc);
				
				switch(menu) {
				case 1 :
					returnPage = movePrevList(page);
					return returnPage;
				case 2 :
					returnPage = moveNextList(page, tableName);
					return returnPage;
				case 3 :
					System.out.println("============================================================================================");
					System.out.println("🔎 내용을 확인하고 싶은 글번호를 입력하세요.");
					int boardNo = Integer.parseInt(sc.nextLine());
					modifyBoardManager(boardNo, sc);
					break;
				default : 
					System.out.println("없는 메뉴입니다.");
					break;
				}
			
			}
		}
		
		//회원게시글 관리 - 상세보기
		public static void modifyBoardManager(int boardNo, Scanner sc) {
			Board bd = BoardDAO.getInstance().memberBoardContent(boardNo);
			if(bd != null) {
				System.out.print("📭 제목 : "+ bd.getBoardTitle() + "\t\t");
				System.out.print("작성자 : " + bd.getMemberId() + "\t");
				System.out.println("작성일 : " + bd.getBoardDate());
				System.out.println("============================================================================================");
				System.out.println(bd.getBoardContent());
				System.out.println("--------------------------------------------------------------------------------------------");
				System.out.println("✉댓글내용");
				//댓글
				System.out.println("--------------------------------------------------------------------------------------------");
				int menu = inputContentListManagerMenu(sc);
				if(menu == 1) {
					bs.writeReply(boardNo); //댓글
				}else if(menu == 2) {
					bs.writeRereply(boardNo); //대댓글
				}else if(menu == 3) {
					bs.deleteBoardmanager(boardNo); //삭제
				}else {
					bs.managerBoardList(); //뒤로가기
				}
			}else {
				System.out.println("조회정보없음");
			}	
		}
				
		//회원게시판 관리 조회 페이지 메뉴
		public static int inputBoardListManagerMenu(Scanner sc) {
			System.out.printf("1.이전 / 2.다음 / 3.상세글보기 / 4.뒤로가기");
			int menu = Integer.parseInt(sc.nextLine());
			
			return menu;
		}
		
		//회원게시판 관리 : 상세조회 페이지메뉴
		public static int inputContentListManagerMenu(Scanner sc) {
			System.out.printf("1.댓글쓰기 / 2.대댓글쓰기 / 4.삭제 / 4.뒤로가기");
			int menu = Integer.parseInt(sc.nextLine());
			
			return menu;
		}
		
		
		
		
}
