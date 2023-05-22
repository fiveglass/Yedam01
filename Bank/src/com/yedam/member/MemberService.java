package com.yedam.member;

import java.util.List;
import java.util.Scanner;

public class MemberService {
	
	public static Member memberInfo = null;
	Scanner sc = new Scanner(System.in);
	
	public void login() {
		System.out.println("- 로 그 인 -");
		System.out.println("ID>");
		String id = sc.nextLine();
		
		System.out.println("PW>");
		String pw = sc.nextLine();
		
		Member member = MemberDAO.getInstance().login(id);
		
		if(member != null) {
			if(member.getMemberPw().equals(pw)) {
				System.out.println("로그인 성공!");
				memberInfo = member;
			}else {
				System.out.println("비밀번호 불일치");
			}
		}else {
			System.out.println("아이디 불일치");
		}
				
	}
	
	public void getAccountInfo() {
		System.out.println("***  고객 정보 조회 ***");
		
		List<Member> list = MemberDAO.getInstance().getAccountInfo();
		for(int i = 0; i<list.size(); i++) {
			System.out.println((i+1) + "번째======");
			System.out.println("계좌번호 : " + list.get(i).getAccount_id());
			System.out.println("예금주 : " + list.get(i).getMemberName());
			System.out.println("잔액 : " + list.get(i).getAccountBalance());
			System.out.println("등급 : " + (list.get(i).getMemberAuth().equals("N") ? "일반사용자" : "은행원"));
		}
	}
}
