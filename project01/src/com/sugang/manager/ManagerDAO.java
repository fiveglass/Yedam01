package com.sugang.manager;

import java.util.ArrayList;
import java.util.List;

import com.sugang.cart.Cart;
import com.sugang.clas.Clas;
import com.sugang.common.DAO;
import com.sugang.ing.Ing;
import com.sugang.member.Member;
import com.sugang.member.MemberDAO;

public class ManagerDAO extends DAO {
	
	private static ManagerDAO mngDao = null;
	
	private ManagerDAO() {
		
	}
	
	public static ManagerDAO getInstance() {
		if(mngDao == null) {
			mngDao = new ManagerDAO();
		}
		return mngDao;
	}
	
	//회원조회 : 전체조회
	public List<Member> getMemberList(int page) {
		List<Member> list = new ArrayList<>();
		Member member = null;
		try {
			conn();
			
			int start = 1 + (page-1) *5;
			int end = 5*page;
			String sql = "SELECT * \r\n" +
						"FROM (SELECT ROWNUM NUM, N.* FROM (SELECT * FROM MEMBER ORDER BY member_join DESC) N ) \r\n"+
						"WHERE NUM BETWEEN ? and ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberPhone(rs.getInt("member_phone"));
				member.setMemberAddr(rs.getNString("member_addr"));
				member.setMemberBirth(rs.getString("member_birth"));
				member.setMemberJoin(rs.getDate("member_join"));
				list.add(member);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//회원조회 : 강좌로 조회
	public List<Ing> referClass(int page, int classNo) {
		List<Ing> list = new ArrayList<>();
		Ing ing = null;
		try {
			conn();
			
			int start = 1 + (page-1) *5;
			int end = 5*page;
			
			String sql = "SELECT * \r\n"
					+ "FROM (SELECT ROWNUM NUM, N.* \r\n"
					+ "FROM (SELECT i.class_name, i.member_id , m.member_name, m.member_phone \r\n"
					+ "FROM ing i join member m on i.member_id = m.member_id where i.class_no = ? ORDER BY i.ing_no DESC) N  )\r\n"
					+ "WHERE NUM BETWEEN ? and ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, classNo);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ing = new Ing();
				ing.setClassName(rs.getString("class_name"));
				ing.setMemberId(rs.getString("member_id"));
				ing.setMemberName(rs.getString("member_name"));
				ing.setMemberPhone(rs.getInt("member_phone"));
				list.add(ing);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//수강내역관리 : 수강신청내역
	public List<Cart> completeCartList(int page) {
		List<Cart> list = new ArrayList<>();
		Cart cart = null;
		try {
			conn();
			
			int start = 1 + (page-1) *5;
			int end = 5*page;
			String sql = "SELECT * \r\n"
					+ "FROM (SELECT ROWNUM NUM, N.* \r\n"
					+ "FROM (SELECT c.member_id, c.class_no , s.class_name\r\n"
					+ "FROM cart c join class s on c.class_no = s.class_no where c.cart_complete = 'Y' ORDER BY c.cart_no DESC) N  )\r\n"
					+ "WHERE NUM BETWEEN ? and ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				cart = new Cart();
				cart.setMemberId(rs.getString("member_id"));
				cart.setClassNo(rs.getInt("class_no"));
				cart.setClassName(rs.getString("class_name"));
				list.add(cart);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	
	//회원조회 : 전화번호로 조회
	public List<Member> referPhone(int memberPhone) {
		List<Member> list = new ArrayList<>();
		Member member = null;
		try {
			conn();
			String sql = "SELECT * FROM member WHERE member_phone = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberPhone);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberPhone(rs.getInt("member_phone"));
				member.setMemberAddr(rs.getNString("member_addr"));
				member.setMemberBirth(rs.getString("member_birth"));
				member.setMemberJoin(rs.getDate("member_join"));	
				list.add(member);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//회원조회 : 이름으로 조회
	public List<Member> referName(String memberName) {
		List<Member> list = new ArrayList<>();
		Member member = null;
		try {
			conn();
			String sql = "SELECT * FROM member WHERE member_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberName);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberPhone(rs.getInt("member_phone"));
				member.setMemberAddr(rs.getNString("member_addr"));
				member.setMemberBirth(rs.getString("member_birth"));
				member.setMemberJoin(rs.getDate("member_join"));	
				list.add(member);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}	
	
	//회원관리 : 연락처수정
	public int updatePhone(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE member SET member_phone = ?"
					+ "WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, member.getMemberPhone());
			pstmt.setString(2, member.getMemberId());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();		
		}finally {
			disconn();
		}
		return result;
	}
	
	//회원관리 : 회원삭제
	public int deleteMember(String memberId) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM member WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//회원관리 : 관리자 계정 생성
	public int membership(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "insert into member values (?, ?, ?, ?, ?, ?, 'H', sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3,member.getMemberName());
			pstmt.setInt(4, member.getMemberPhone());
			pstmt.setString(5, member.getMemberAddr());
			pstmt.setString(6, member.getMemberBirth());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//강좌관리 : 강좌등록
	public int insertClass(Clas clas) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO class VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, clas.getClassNo());
			pstmt.setString(2, clas.getClassName());
			pstmt.setString(3, clas.getClassTeacher());
			pstmt.setInt(4, clas.getClassLimit());
			pstmt.setInt(5, clas.getClassNumber());
			pstmt.setString(6, clas.getClassDate());
			pstmt.setString(7, clas.getClassSemester());
			pstmt.setString(8, clas.getClassExplain());
			
			result = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//강좌관리 : 강좌수정
	public int modifyClass(int selectNo, String changeValue, int classNo) {
	    int result = 0;
	    try {
	        conn();

	        if(selectNo==1) {
	            String sql = "update class set class_teacher = ? where class_no = ?";
	             pstmt = conn.prepareStatement(sql);
	             pstmt.setString(1, changeValue);
	             pstmt.setInt(2, classNo);
	             result = pstmt.executeUpdate();
	        } else if(selectNo==2) {
	            String sql2 = "update class set class_limit = ? where class_no = ?";
	            pstmt.setInt(1, Integer.parseInt(changeValue));
	            pstmt.setInt(2, classNo); 
	            result = pstmt.executeUpdate();
	        } else if(selectNo==3) {
	        	String sql3 = "update class set class_date = ? where class_no = ?";
	            pstmt.setString(1, changeValue);
	            pstmt.setInt(2, classNo); 
	            result = pstmt.executeUpdate();
	        } else if(selectNo==4) {
	        	String sql4 = "update class set class_semester = ? where class_no = ?";
	            pstmt.setString(1, changeValue);
	            pstmt.setInt(2, classNo);
	            result = pstmt.executeUpdate();
	        }else if(selectNo==5) {
	        	String sql5 = "update class set class_explain = ? where class_no = ?";
	            pstmt.setString(1, changeValue);
	            pstmt.setInt(2, classNo);
	            result = pstmt.executeUpdate();
	        }

	    }catch(Exception e) {
	        e.printStackTrace();
	    }finally {
	        disconn();
	    }
	    return result;
	}
	
	//강좌관리 : 강좌삭제
	public int deleteClass(int classNo) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM class WHERE class_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, classNo);
			
			result = pstmt.executeUpdate();
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}

	
	
	
	
	
	
	//총게시물 카운트
		public int getCount(String plusQuery) {
			int count = 0;
			try {
				conn();
				String sql = "SELECT COUNT(*) count FROM ";
				sql += plusQuery;
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt("count");
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				disconn();
			}
			return count;
		}
	
}
