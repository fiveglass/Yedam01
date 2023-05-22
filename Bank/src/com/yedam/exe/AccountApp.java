package com.yedam.exe;

import java.util.Scanner;

import com.yedam.account.AccountService;
import com.yedam.member.MemberService;

public class AccountApp {
	
	Scanner sc = new Scanner(System.in);
	AccountService as = new AccountService();
		
	public AccountApp() {
		run();
	}
	
	private void run() {
		while(true) {
			menu();
			String menuNo = sc.nextLine();
			
			if(menuNo.equals("1")) {
				as.insertMember();
			}else if(menuNo.equals("2")) {
				as.insertAccount();
			}else if(menuNo.equals("3")) {
				as.inoutMoney();
			}else if(menuNo.equals("4")) {
				as.transferMoney();
			}else if(menuNo.equals("5")) {
				as.delateAccount();
			}else if(menuNo.equals("6")) {
				System.out.println("은행원 업무 종료");
				MemberService.memberInfo = null;
				break;
			}
		}
	}
	
	private void menu() {
		System.out.println("1. 고객 등록 | 2. 계좌 개설 | 3. 입출금 | 4. 계좌 이체 | 5. 계좌 해지 | 6.뒤로 가기");
		
	}
}
