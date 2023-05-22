package com.test.exe;

import java.util.ArrayList;
import java.util.List;

import com.test.coffee.DAO;

public class CoffeeDAO extends DAO{

	private static CoffeeDAO cfDao = null;
	
	private CoffeeDAO() {
		
	}
	
	public static CoffeeDAO getInstance() {
		if(cfDao == null) {
			cfDao = new CoffeeDAO();
		}
		return cfDao;
	}
	
	//메뉴조회
	public List<Coffee> getCoffeeList() {
		List<Coffee> list = new ArrayList<>();
		Coffee cf = null;
		try {
			conn();
			String sql = "SELECT * FROM coffee ORDER BY 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				cf = new Coffee();
				cf.setMenu(rs.getString("menu"));
				cf.setPrice(rs.getInt("price"));
				list.add(cf);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//메뉴상세조회
	public Coffee getCoffee(String menu) {
		Coffee cf = null;
		try {
			conn();
			String sql = "SELECT * FROM coffee WHERE menu = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cf = new Coffee();
				cf.setMenu(rs.getString("menu"));
				cf.setPrice(rs.getInt("price"));
				cf.setExplain(rs.getString("explain"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return cf;
	}
	
	//메뉴등록
	public int insertCf(Coffee cf) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO coffee VALUES (?,?,?,'0')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cf.getMenu());
			pstmt.setInt(2, cf.getPrice());
			pstmt.setString(3, cf.getExplain());
			
			result = pstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				disconn();
			}
			return result;
		 }
	
	//메뉴삭제
	public int deleteCf(String menu) {
		int result = 0;
		try {
			conn();
			String sql = "delete from coffee where menu = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu);
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//판매
	public int salesCf(Coffee cf) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE coffee SET sales = sales + 1 WHERE menu = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,cf.getMenu());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//매출
	public List<Coffee> salesTotal() {
		List<Coffee> list = new ArrayList<>();
		Coffee cf = null;
		try {
			conn();
			String sql = "SELECT menu, sales, coffee.price*coffee.sales FROM coffee ORDER BY 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				cf = new Coffee();
				cf.setMenu(rs.getString("menu"));
				cf.setSales(rs.getInt("sales"));
				cf.setSalesSum(rs.getInt("coffee.price*coffee.sales"));
				list.add(cf);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
}
