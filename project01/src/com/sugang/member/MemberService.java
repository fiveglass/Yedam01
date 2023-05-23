package com.sugang.member;

import java.util.Scanner;

public class MemberService {
	public static Member memberInfo = null;
	Scanner sc = new Scanner(System.in);
	
	//로그인 기능
	public void login() {
		System.out.println("아이디>");
		String id = sc.nextLine();
		
		System.out.println("비밀번호>");
		String pw = sc.nextLine();
		
		System.out.println("---------------------");
		
		Member member = MemberDAO.getInstance().login(id);
		
		if(member != null) {
			if(member.getMemberPw().equals(pw)) {
				System.out.println("로그인 성공");
				memberInfo = member;
			}else {
				System.out.println("비밀번호 불일치");
			}
		}else {
			System.out.println("아이디 불일치");
		}
	
	}
	
	//회원가입 기능
	public void membership() {
		Member member = new Member();
		System.out.println("=============고객등록============");
		
		System.out.println("아이디>");
		member.setMemberId(sc.nextLine());
		
		System.out.println("비밀번호>");
		member.setMemberPw(sc.nextLine());
		
		System.out.println("이름>");
		member.setMemberName(sc.nextLine());
		
		System.out.println("전화번호>");
		member.setMemberPhone(Integer.parseInt(sc.nextLine()));
		
		System.out.println("주소>");
		member.setMemberAddr(sc.nextLine());
		
		System.out.println("생년월일(생년월일8자리)>");
		member.setMemberBirth(sc.nextLine());
		
		int result = MemberDAO.getInstance().membership(member);
		
		if(result > 0) {
			System.out.println("회원 등록");
		} else {
			System.out.println("회원 실패");
		}
	}
}
