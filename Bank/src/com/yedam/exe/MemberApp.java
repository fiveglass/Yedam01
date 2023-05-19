package com.yedam.exe;

import java.util.Scanner;

public class MemberApp {
	Scanner sc = new Scanner(System.in);

	public MemberApp() {
		memberRun();
	}

	private void memberRun() {
		boolean flag = true;
		while (flag) {
			menu();
			String selectNo = sc.nextLine();
			switch (selectNo) {
			case "1":

				break;
			case "2":

				break;
			case "3":

				break;
			case "4":
				flag = false;
				break;
			}
		}
	}

	// 고객 메뉴
	private void menu() {
		// -> 계좌 조회, 입출금(한번에 구현), 이체
		System.out.println("1. 계좌 조회 | 2. 입출금 | 3. 이체 | 4. 뒤로가기");
	}
}
