package com.sugang.ing;

import java.util.ArrayList;
import java.util.List;

import com.sugang.common.DAO;
import com.sugang.member.MemberService;

public class IngDAO extends DAO{
	
	private static IngDAO ingDao = null;
	
	private IngDAO() {
		
	}
	
	public static IngDAO getInstance() {
		if(ingDao == null) {
			ingDao = new IngDAO();
		}
		return ingDao;
	}
	
	//마이페이지 : 수강내역조회
	public List<Ing> mypagestudying() {
		List<Ing> list = new ArrayList<>();
		Ing ing = null;
		try {
			conn();
			String sql = "SELECT member_id, class_no, class_name  \r\n"
					+ "FROM ing \r\n"
					+ "WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MemberService.memberInfo.getMemberId());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ing = new Ing();
				ing.setMemberId(rs.getString("member_id"));
				ing.setClassNo(rs.getInt("class_no"));
				ing.setClassName(rs.getString("class_name"));
				list.add(ing);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//내정보관리 : 수강취소
	public int deleteStudying(int classno) {
		List<Ing> list = mypagestudying();
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM ing WHERE member_id = ? AND class_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MemberService.memberInfo.getMemberId());
			pstmt.setInt(2, classno);
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//내정보관리 : 수강취소 - 환불금액정보
	public Ing refundClass(int classno) {
		Ing ing = null;
		try {
			conn();
			String sql = "SELECT * FROM ing WHERE member_id = ? AND class_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MemberService.memberInfo.getMemberId());
			pstmt.setInt(2, classno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				ing = new Ing();
				ing.setClassSemester(rs.getString("class_semester"));
				ing.setIngTuition(rs.getInt("ing_tuition"));
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return ing;
	}
	 
}

	
	
	
	
	
	