package com.yedam.store;

import java.util.List;
import java.util.Scanner;

public class StoreService {
	
	Scanner sc = new Scanner(System.in);
	
//	1) 모든 가게 정보 조회
	public void getStoreList() {
		List<Store> list =
				StoreDAO.getInstance().getStoreList();
		for(Store store : list) {
			System.out.println("---------------------------------");
			System.out.println("상호명 : " + store.getStoreName());
			System.out.println("가게번호 : " + store.getStoreId());
			System.out.println("연락처 : " + store.getStoreTel());
			System.out.println("주소 : " + store.getStoreAddr());
			System.out.println("매출 : " + store.getStoreSales());
		}
	}
//	2) 지역구별 매출 합계 조회-> 대구 중구 어디어디
	public void getStoreSales() {
		List<Store> list = 
				StoreDAO.getInstance().getStoreSales();
		for(int i = 0; i<list.size(); i++) {
			System.out.println("-------------------------------------");
			System.out.println("지역구 : " + list.get(i).getStoreAddr());
			System.out.println("매출합계 : " + list.get(i).getStoreSales());
		}
	}
//	3) 가게 정보 입력
	public void insertStore() {
		Store store = new Store();
		System.out.println("- 가게 등록 -");
		System.out.println("상호명>");
		store.setStoreName(sc.nextLine());
		
		System.out.println("연락처>");
		store.setStoreTel(sc.nextLine());
		
		System.out.println("주 소>");
		store.setStoreAddr(sc.nextLine());
		
		System.out.println("매 출>");
		store.setStoreSales(Integer.parseInt(sc.nextLine()));
		
		int result = StoreDAO.getInstance().insertStore(store);
		
		if(result > 0) {
			System.out.println("가게 정보 입력 완료");
		}else {
			System.out.println("가게 정보 입력 실패");
		}
	}
//	4) 매출 수정
	public void updateSales() {
		Store store = new Store();
		System.out.println("- 매 출 수 정 -");
		
		System.out.println("ID>");
		store.setStoreId(Integer.parseInt(sc.nextLine()));
		
		System.out.println("매출>");
		store.setStoreSales(Integer.parseInt(sc.nextLine()));
		int result = StoreDAO.getInstance().updateSales(store);
		
		if(result > 0) {
			System.out.println("매출 수정 완료");
		}else {
			System.out.println("매출 수정 실패");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
