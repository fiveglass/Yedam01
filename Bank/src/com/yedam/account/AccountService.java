package com.yedam.account;

import java.util.Scanner;

import com.yedam.member.Member;

public class AccountService {
	Scanner sc = new Scanner(System.in);
	
	
	//고객등록
	public void insertMember() {
		Member member = new Member();
		System.out.println("***** 고객등록 *****");
		
		System.out.println("ID>");
		member.setMemberId(sc.nextLine());
		
		System.out.println("PW>");
		member.setMemberPw(sc.nextLine());
		
		System.out.println("Name>");
		member.setMemberName(sc.nextLine());
		
		int result = AccountDAO.getInstance().insertMember(member);
		
		if(result > 0) {
			System.out.println("고객 등록 성공");
		}else {
			System.out.println("고객 등록 실패");
		}
	}
	
	//계좌 개설
	public void insertAccount() {
		Account account = new Account();
		System.out.println("**** 계좌 개설 ****");
		
		System.out.println("계좌번호>");
		account.setAccountId(sc.nextLine());
		
		System.out.println("예금액>");
		account.setAccountBalance(Integer.parseInt(sc.nextLine()));
		
		System.out.println("고객ID>");
		account.setMemberId(sc.nextLine());
		
		int result = AccountDAO.getInstance().insertAccount(account);
		
		if(result > 0) {
			System.out.println("계좌개설성공");
		}else {
			System.out.println("계좌개설실패");
		}
	}
	
	//입출금
	//입,출금
		public void inoutMoney() {
			System.out.println("**** 입 출 금 ****");
			
			System.out.println("1.입금 | 2. 출금");
			int selectNo = Integer.parseInt(sc.nextLine());
			
			System.out.println("계좌 번호 >");
			Account account = new Account();
			account.setAccountId(sc.nextLine());
			
			
			if(selectNo == 1) {
				System.out.println("입금 금액 >");
				
			}else if(selectNo == 2)
			System.out.println("출금 금액 >");
		
		
			account.setAccountBalance(Integer.parseInt(sc.nextLine()));
			
			int result = AccountDAO.getInstance().inoutMoney(account, selectNo);
			
			if(result > 0) {
				if(selectNo == 1) {
					System.out.println("입금 성공");
				}else {
					System.out.println("출금 성공");
				}
			}else {
				if(selectNo == 1) {
					System.out.println("입금 실패");
				}else {
					System.out.println("출금 성공");
				}
			}
			
		}
		
		//계좌이체
		public void transferMoney(){
			System.out.println("**** 계좌이체 ****");
			System.out.println("받는 계좌>");
			String toAccount = sc.nextLine();
			System.out.println("보내는 계좌>");
			String fromAccount = sc.nextLine();
			System.out.println("이체금액>");
			int balance = Integer.parseInt(sc.nextLine());
			
			int result = AccountDAO.getInstance().transferMoney(toAccount, fromAccount, balance);
			
			if(result == 1) {
				System.out.println("이체성공");
			}else {
				System.out.println("이체실패");
			}
					
		}
		
		//계좌해지
		 public void delateAccount() {
			 System.out.println("**** 계좌해지 ****");
			 System.out.println("계좌>");
			 String accountId = sc.nextLine();
			 
			 int result = AccountDAO.getInstance().deleteAccount(accountId);
			 
			 if(result == 1) {
				 System.out.println("계좌해지완료");
			 }else {
				 System.out.println("계좌해지실패");
			 }
		 }
}
	
	
	
