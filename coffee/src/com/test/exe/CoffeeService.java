package com.test.exe;

import java.util.List;
import java.util.Scanner;

public class CoffeeService {
	Scanner sc = new Scanner(System.in);
	
	//메뉴 조회
	public void getCoffeeList() {
		List<Coffee> list = CoffeeDAO.getInstance().getCoffeeList();
		System.out.println("***************************");
		if(list.size() == 0) {
			System.out.println("입력된 메뉴 정보가 없습니다.");
		}else {
			for(int i = 0; i < list.size(); i++) {
				System.out.print("메뉴 : " + list.get(i).getMenu());
				System.out.println(" 가격 : " + list.get(i).getPrice());
			}
		}
	}
	
	//메뉴 상세 조회
	public void getCoffee() {
		System.out.println("***************************");
		System.out.println("메뉴 입력>");
		String menu = sc.nextLine();
		Coffee cf = CoffeeDAO.getInstance().getCoffee(menu);
		if(cf != null) {
			System.out.print("메뉴 : " + cf.getMenu());
			System.out.print(" 가격 : " + cf.getPrice());
			System.out.println(" 설명 : " + cf.getExplain());
		}else {
			System.out.println("조회 정보 없음");
		}
	}
	
	//메뉴등록
	public void insertCf() {
		Coffee cf = new Coffee();
		System.out.println("***************************");
		System.out.println("메뉴 입력>");
		cf.setMenu(sc.nextLine());
		
		System.out.println("가격 입력>");
		cf.setPrice(Integer.parseInt(sc.nextLine()));
		
		System.out.println("설명 입력>");
		cf.setExplain(sc.nextLine());
		
		int result = CoffeeDAO.getInstance().insertCf(cf);
		
		if(result > 0) {
			System.out.println("메뉴 등록 완료");
		}else {
			System.out.println("메뉴 등록 실패");
		}
	}
	
	//메뉴삭제
	public void deleteCf() {
		System.out.println("메뉴 입력>");
		String menu = sc.nextLine();
		
		int result = CoffeeDAO.getInstance().deleteCf(menu);
		
		if(result == 1) {
			System.out.println("메뉴 삭제 완료");
		}else {
			System.out.println("메뉴 삭제 실패");
		}
	}
	
	//판매
	public void salesCf() {
		Coffee cf = new Coffee();
		System.out.println("메뉴 입력>");
		cf.setMenu(sc.nextLine());
		
		int result = CoffeeDAO.getInstance().salesCf(cf);
		if(result > 0) {
			System.out.println("판매량 완료");
		}else {
			System.out.println("판매량 등록 실패");
		}
	}
	
	//매출
	public void salesTotal() {
		List<Coffee> list = CoffeeDAO.getInstance().salesTotal();
		System.out.println("***********************");
		if (list.size() == 0) {
			System.out.println("| 정보가 입력이 되어 있지 않습니다.");
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.print("메뉴 : " + list.get(i).getMenu());
				System.out.print(", 판매갯수 : " + list.get(i).getSales());
				System.out.println(", 판매금액 : " + list.get(i).getSalesSum());
			}
		}
	}
}
