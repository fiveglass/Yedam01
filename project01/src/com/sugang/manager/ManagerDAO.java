package com.sugang.manager;

import java.util.ArrayList;
import java.util.List;

import com.sugang.clas.Clas;
import com.sugang.common.DAO;
import com.sugang.member.Member;

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
	
}
