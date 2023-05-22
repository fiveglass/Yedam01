package com.yedam.exe;

import java.util.Scanner;

import com.yedam.member.MemberService;

public class Application {

	Scanner sc = new Scanner(System.in);
	MemberService ms = new MemberService();
	public Application() {
		run();
	}

	private void run() {
		while (true) {
			if(MemberService.memberInfo == null) {
			System.out.println("1. 로그인 | 2. 종료");
			int menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				//로그인 기능				
					ms.login();	
			} else if (menu == 2) {
				System.out.println("은행 업무 종료");
				break;
			} else {
				System.out.println("없는 메뉴 선택!");
			}
			} else if(MemberService.memberInfo!=null) {
				//로그인한 정보를 토대로 업무를 나눔(고객(N)/은행원(B))
				if(MemberService.memberInfo.getMemberAuth().equals("N")) {
					//고객
					new MemberApp();
				}else if(MemberService.memberInfo.getMemberAuth().equals("B")) {
					//은행원
					new AccountApp();
				}
				
			}
		}
	}
}
