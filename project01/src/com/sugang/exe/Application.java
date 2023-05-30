package com.sugang.exe;

import java.util.Scanner;

import com.sugang.member.MemberService;

public class Application {

	Scanner sc = new Scanner(System.in);
	MemberService ms = new MemberService();
	public Application() {
		run();
	}
	
	private void run() {
		while (true) {
			if(MemberService.memberInfo == null) {
				System.out.println("🙌 예 담 종 합 사 회 복 지 관 회 원 시 스 템 ");
				System.out.println("     1.로그인 | 2.회원가입 | 3.종료");
				System.out.println("---------------------------------------");
				int menu = Integer.parseInt(sc.nextLine());
				if(menu == 1) {
					//로그인
					ms.login();
				} else if(menu == 2) {
					ms.membership();
				} else if(menu == 3) {
					System.out.println("수강관리 시스템 종료");
					break;
				} else {
					System.out.println("그런 메뉴는 없어요!");
				}
			} else if(MemberService.memberInfo != null) {
				if(MemberService.memberInfo.getMemberType().equals("M")) {
					new MemberApp();
				}else if(MemberService.memberInfo.getMemberType().equals("H")) {
					new ManagerApp();
				}
			}
		}
	}
	

}
