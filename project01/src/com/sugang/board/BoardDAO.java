package com.sugang.board;

import java.util.ArrayList;
import java.util.List;

import com.sugang.common.DAO;
import com.sugang.member.Member;
import com.sugang.member.MemberService;

public class BoardDAO extends DAO {
	
	private static BoardDAO bdDao = null;
	
	private BoardDAO() {
		
	}
	
	public static BoardDAO getInstance() {
		if(bdDao == null) {
			bdDao = new BoardDAO();
		}
		return bdDao;
	}
	
	//회원게시판 : 목록
	public List<Board> memberBoardList(int page) {
		List<Board> list = new ArrayList<>();
		Board board = null;
		try {
			conn();
			
			int start = 1 + (page-1) *5;
			int end = 5*page;
			String sql = "SELECT * \r\n"
					+ "FROM (SELECT ROWNUM NUM, N.* FROM (SELECT * FROM board ORDER BY board_date DESC) N ) \r\n"
					+ "WHERE NUM BETWEEN ? and ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				board = new Board();
				board.setBoardNo(rs.getInt("board_no"));
				board.setBoardTitle(rs.getString("board_title"));
				board.setMemberId(rs.getString("member_id"));
				board.setBoardDate(rs.getDate("board_date"));
				list.add(board);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//회원게시판 : 글쓰기
	public int writeBoard(Board board) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO board VALUES (board_seq.NEXTVAL, ?, ?, sysdate, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setString(3, board.getMemberId());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//회원게시판 : 목록 - 상세글보기
	public Board memberBoardContent(int boardNo) {
		Board bd = null;
		try {
			conn();
			String sql = "SELECT * FROM board WHERE board_no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bd = new Board();
				bd.setBoardTitle(rs.getString("board_title"));
				bd.setMemberId(rs.getString("member_id"));
				bd.setBoardDate(rs.getDate("board_date"));
				bd.setBoardContent(rs.getString("board_content"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return bd;
	}
	
	//회원게시판 : 상세글보기 - 제목수정
	public int modifyTitle(Board board, int boardNo) {
		int result=0;
		try {
			conn();
			String sql = "UPDATE board SET board_title = ? WHERE board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setInt(2, boardNo);
			rs = pstmt.executeQuery();
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//회원게시판 : 상세글보기 - 내용수정
	public int modifyContent(Board board, int boardNo) {
		int result=0;
		try {
			conn();
			String sql = "UPDATE board SET board_content = ? WHERE board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBoardContent());
			pstmt.setInt(2, boardNo);
			rs = pstmt.executeQuery();
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//회원게시판 : 상세글보기 - 삭제
	public int deleteBoard(int boardNo) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM board WHERE board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	//회원게시판 : 수정삭제 시 본인확인
	public Board checkMemberId(int boardNo) {
		Board bd = null;
		try {
			conn();
			String sql = "SELECT member_id FROM board WHERE board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bd = new Board();
				bd.setMemberId(rs.getString("member_id"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return bd;
	}
	
	//회원게시판 : 상세글보기 & 댓글조회
	public List<Board> replyList(int boardNo) {
		List<Board> list = new ArrayList<>();
		Board board = null;
		try {
			conn();
			String sql = "SELECT * FROM reply where board_no = ? ORDER BY parent_no, reply_date";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				board = new Board();
				board.setReplyContent(rs.getString("reply_content"));
				board.setReplydate(rs.getDate("reply_date"));
				board.setMemberId(rs.getString("member_id"));
				board.setReplyNo(rs.getInt("reply_no"));
				board.setParentNo(rs.getInt("parent_no"));
				list.add(board);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//회원게시판 : 상세글보기 & 댓글조회 - 댓글작성
	public int writeReply(Board board) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO reply VALUES (reply_seq.NEXTVAL, ?, sysdate, ?, ?, reply_seq.NEXTVAL)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getReplyContent());
			pstmt.setString(2, MemberService.memberInfo.getMemberId());
			pstmt.setInt(3, board.getBoardNo());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	//회원게시판 : 상세글보기 & 댓글조회 - 대댓글작성
	public int writeRereply(Board board) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO reply VALUES (reply_seq.NEXTVAL, ?, sysdate, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getReplyContent());
			pstmt.setString(2, MemberService.memberInfo.getMemberId());
			pstmt.setInt(3, board.getBoardNo());
			pstmt.setInt(4, board.getParentNo());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
}
