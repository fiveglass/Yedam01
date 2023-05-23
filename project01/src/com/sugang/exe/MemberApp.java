package com.sugang.exe;

import java.util.Scanner;

public class MemberApp {
	Scanner sc = new Scanner(System.in);
	//MemberService ms = new MemberService();
	
	public MemberApp() {
		memberGo();
	}
	
	private void memberGo() {
		boolean run = true;
		while(run) {
			memberMenu();
			String selectNo = sc.nextLine();
			switch (selectNo) {
			case "1" :
				System.out.println("*** *** 마 이 페 이 지 *** ***");
				System.out.println("1.내정보 조회 | 2.수강내역 조회 | 3.뒤로가기");
				selectNo = sc.nextLine();
				if(selectNo.equals("1")) {
					
				}else if(selectNo.equals("2")){
					
				}else {
					run=false;
				}
				break;
			case "2" :
				System.out.println("*** *** 내 정 보 관 리 *** ***");
				System.out.println("1.연락처수정 | 2.회원삭제 | 3.뒤로가기");
				selectNo = sc.nextLine();
				if(selectNo.equals("1")) {
									
				}else if(selectNo.equals("2")) {
									
				}else {
					run=false;
				}
				break;
			case "3" : 
				System.out.println("*** *** 수 강 꾸 러 미 *** ***");
				System.out.println("1.수강신청 | 2.수강신청꾸러미 | 3.수강신청내역 | 4.뒤로가기");
				selectNo = sc.nextLine();
				if(selectNo.equals("1")) {
									
				}else if(selectNo.equals("2")) {
										
				}else if(selectNo.equals("3")) {
					
				}else {
					run=false;
				}
				break;
			case "4" : 
				System.out.println("*** *** 강 좌 조 회 *** ***");
				System.out.println("1.강좌목록 | 2.강좌정보 | 3.뒤로가기");
				selectNo = sc.nextLine();
				if(selectNo.equals("1")) {
									
				}else if(selectNo.equals("2")) {
										
				}else {
					run=false;
				}
				break;
			}
		}
	}
	
	public void memberMenu() {
		System.out.println("1.마이페이지 | 2.내정보관리 | 3.수강꾸러미 | 4.강좌조회");
	}
}
