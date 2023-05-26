package com.sugang.cart;

import java.util.ArrayList;
import java.util.List;

import com.sugang.clas.Clas;
import com.sugang.common.DAO;
import com.sugang.member.MemberService;

public class CartDAO extends DAO{
	
	private static CartDAO cartDao = null;
	
	private CartDAO() {
		
	}
	
	public static CartDAO getInstance() {
		if(cartDao == null) {
			cartDao = new CartDAO();
		}
		return cartDao;
	}
	
	//수강꾸러미 : 수강신청
	
	
	//수강꾸러미 : 수꾸 - 목록조회
	 public List<Clas> CartIndex(String semester) {
		 List<Clas> list = new ArrayList<>();
		 Clas cs = null;
		 try {
			 conn();
			 String sql = "SELECT * FROM class WHERE class_semester not in ( ? )";
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, semester);
			 
			 rs = pstmt.executeQuery();
			 
			 while(rs.next()) {
				 cs = new Clas();
				 cs.setClassNo(rs.getInt("class_no"));
				 cs.setClassName(rs.getString("class_name"));
				 cs.setClassTeacher(rs.getString("class_teacher"));
				 cs.setClassDate(rs.getString("class_date"));
				 cs.setClassLimit(rs.getInt("class_limit"));
				 cs.setClassNumber(rs.getInt("class_number"));
				 list.add(cs);
				 
			 }
			 
			
		 }catch(Exception e) {
			 e.printStackTrace();
		 }finally {
			 disconn();
		 }
		 return list;
	 }
	
	//수강꾸러미 : 수꾸 - 강좌번호 요일 출력
	public Clas dateCheck(int classNo) {
		Clas cs = null;
		try {
			conn();
			String sql = "SELECT class_date FROM class WHERE class_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, classNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cs = new Clas();
				cs.setClassDate(rs.getString("class_date"));
			}	
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return cs;
	}
	 
	 
	//수강꾸러미 : 수꾸 - 겹치는 강좌 확인
	public List<Clas> applyCheck(int classNo) {
		List<Clas> list = new ArrayList<>();
		Clas cs = null;

		try {
			conn();
		
			String sql = "select c.class_date, a.class_no\r\n"
					+ "from class c join cart a on c.class_no = a.class_no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				cs = new Clas();
				cs.setClassDate(rs.getString("class_date"));
				cs.setClassNo(rs.getInt("class_no"));
				list.add(cs);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//수강꾸러미 : 수꾸 - 등록
	public int applyClass(int classNo) {
		int result = 0;
		try {
			conn();
			String sql = "insert into cart values (cart_seq.nextval, 'Y', ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MemberService.memberInfo.getMemberId());
			pstmt.setInt(2, classNo);
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//수강꾸러미 : 수강신청내역
	public List<Cart> applyStory() {
		List<Cart> list = new ArrayList<>();
		Cart cart = null;
		try {
			conn();
			String sql = "SELECT c.class_no, s.class_name \r\n"
					+ "FROM cart c join class s on c.class_no = s.class_no \r\n"
					+ "WHERE member_id = ? AND cart_complete = 'Y'";  
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MemberService.memberInfo.getMemberId());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				cart = new Cart();
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
	
}
