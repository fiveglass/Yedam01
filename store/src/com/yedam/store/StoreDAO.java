package com.yedam.store;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class StoreDAO extends DAO{
	
	private static StoreDAO storeDao = null;
	
	private StoreDAO() {
		
	}
	
	public static StoreDAO getInstance() {
		if(storeDao == null) {
			storeDao = new StoreDAO();
		}
		return storeDao;
	}
	
//	1) 모든 가게 정보 조회
	public List<Store> getStoreList(){
		List<Store> list = new ArrayList<>();
		Store store = null;
		try {
			conn();
			String sql = "SELECT * FROM store";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				store = new Store();
				store.setStoreId(rs.getInt("store_id"));
				store.setStoreName(rs.getString("store_name"));
				store.setStoreTel(rs.getString("store_tel"));
				store.setStoreAddr(rs.getString("store_addr"));
				store.setStoreSales(rs.getInt("store_sales"));
				list.add(store);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
//	2) 지역구별 매출 합계 조회-> 대구 중구 어디어디
	public List<Store> getStoreSales(){
		List<Store> list = new ArrayList<>();
		Store store = null;
		try {
			conn();
			String sql = "SELECT SUBSTR(store_addr, 4,3) AS location, sum(store_sales) \"loc_Sales\"\r\n"
					+ "FROM store\r\n"
					+ "GROUP BY SUBSTR(store_addr, 4,3)";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				store = new Store();
				store.setStoreAddr(rs.getString("location"));
				store.setStoreSales(rs.getInt("loc_Sales"));
				list.add(store);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
//	3) 가게 정보 입력
//	STORE_ID    NOT NULL NUMBER 1) 데이터 입력 2) 서브쿼리를 활용해서 자동 부여 3) 시퀀스를 활용해서 자동 부여
//	STORE_NAME           VARCHAR2(100) 
//	STORE_TEL            VARCHAR2(15)  
//	STORE_ADDR           VARCHAR2(100) 
//	STORE_SALES          NUMBER     
	public int insertStore(Store store) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO store VALUES (\r\n"
					+ "(SELECT COUNT(*)+1 FROM store),"
					+ " ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, store.getStoreName());
			pstmt.setString(2, store.getStoreTel());
			pstmt.setString(3, store.getStoreAddr());
			pstmt.setInt(4, store.getStoreSales());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
//	4) 매출 수정
	public int updateSales(Store store) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE store SET store_sales = ? WHERE store_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, store.getStoreSales());
			pstmt.setInt(2, store.getStoreId());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
}
