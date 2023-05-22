package com.test.common;

import java.util.Scanner;

import com.test.exe.CoffeeService;

public class ExeApp {
	private String menu = null;
	private Scanner sc = new Scanner(System.in);
	private CoffeeService cs = new CoffeeService();
	boolean go = true;
	
	public ExeApp() {
		start();
	}
	
	private void start() {
		while(go) {
			menu();
			
			switch(menu){
			case "1" :
				cs.getCoffeeList();
				break;
			case "2" :
				cs.getCoffee();
				break;
			case "3" :
				cs.insertCf();
				break;
			case "4" :
				cs.salesCf();
				break;
			case "5" :
				cs.deleteCf();
				break;
			case "6" :
				cs.salesTotal();
				break;
			case "7" :
				System.out.println("end of prog");
				go = false;
			}
		}
	}
	
	private void menu() {
		System.out.println("1. 메뉴 조회 | 2. 메뉴 상세 조회 | 3. 메뉴 등록 | 4. 판매 | 5. 메뉴 삭제 | 6. 매출 | 7.종료 ");
		System.out.println("메뉴 입력>");
		menu = sc.nextLine();
	}
}
