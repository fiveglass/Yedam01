package com.sugang.utils;

import java.util.Scanner;

import com.sugang.clas.Clas;
import com.sugang.clas.ClassDAO;
import com.sugang.manager.ManagerDAO;

public class pageMenu {

	public static int getPageMenu(int page, Scanner sc, String tableName) {
		int returnPage;
		
		while(true) {
			int menu = inputMemberListMenu(sc);
			
			switch(menu) {
			case 1 :
				returnPage = movePrevList(page);
				return returnPage;
			case 2 :
				returnPage = moveNextList(page, tableName);
				return returnPage;
			case 3 :
				return 0;
			default : 
				System.out.println("없는 메뉴입니다.");
				break;
			}
		
		}
	}
	
	//회원조회 : 전체조회 페이지메뉴
	public static int inputMemberListMenu(Scanner sc) {
		System.out.printf("                   1.이전 / 2.다음 / 3.뒤로가기");
		int menu = Integer.parseInt(sc.nextLine());
		
		return menu;
	}
	
	public static int movePrevList(int page) {
		if(page == 1) {
			System.out.println("=====================");
			System.out.println("이전페이지가 존재하지 않습니다.");
			System.out.println("=====================");
		}else {
			page--;
		}
		return page;
		
	}

	public static int moveNextList(int page, String tableName) {
		int count = ManagerDAO.getInstance().getCount(tableName);
		int lastPage = count/5;
		lastPage = count%5 > 0 ? lastPage+1 : lastPage;
		if(page == lastPage) {
			System.out.println("=====================");
			System.out.println("다음페이지가 존재하지 않습니다.");
			System.out.println("=====================");
		}else {
			page++;	
		}
		return page;
	}

	
	//강의조회 : 강의목록 상세조회 메뉴
	public static int getPageMenu2(int page, Scanner sc, String tableName) {
		int returnPage;
		
		while(true) {
			int menu = inputMemberListMenu2(sc);
			
			switch(menu) {
			case 1 :
				returnPage = movePrevList(page);
				return returnPage;
			case 2 :
				returnPage = moveNextList(page, tableName);
				return returnPage;
			case 3 :
				System.out.println("============================================================================================");
				System.out.println("🔎 강의 내용을 확인하고 싶다면 강좌번호를 입력해주세요");
				int classno = Integer.parseInt(sc.nextLine());
				Clas cs = ClassDAO.getInstance().indexContent(classno);
				if(cs != null) {
					System.out.println("🔎" + cs.getClassName() + "'의 강의 내용");
					System.out.println(cs.getClassExplain());
				}else {
					System.out.println("조회정보없음");
				}	
				break;
			case 4 :
				return 0;
			default : 
				System.out.println("없는 메뉴입니다.");
				break;
			}
		
		}
	}
	
	//회원조회 : 전체조회 페이지메뉴
	public static int inputMemberListMenu2(Scanner sc) {
		System.out.printf("            1.이전 / 2.다음 / 3.상세내용검색 / 4.뒤로가기");
		int menu = Integer.parseInt(sc.nextLine());
		
		return menu;
	}
	
}
