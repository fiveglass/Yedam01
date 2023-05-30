package com.sugang.member;

import java.util.List;
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
		
		
		Member member = MemberDAO.getInstance().login(id);
		
		if(member != null) {
			if(member.getMemberPw().equals(pw)) {
				System.out.println("=========");
				System.out.println("로그인 성공");
				System.out.println("=========");
				memberInfo = member;
			}else {
				System.out.println("=============");
				System.out.println("비밀번호 불일치");
				System.out.println("=============");
			}
		}else {
			System.out.println("===========");
			System.out.println("아이디 불일치");
			System.out.println("===========");
		}
	
	}
	
	//회원가입 기능
	public void membership() {
		Member member = new Member();
		System.out.println("🙌 예 담 종 합 사 회 복 지 관 회 원 시 스 템 --------------------------------");
		System.out.println("🤝 회 원 가 입 ----------------------------------------------------------");
		
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
			System.out.println("🎉 회원 등록을 환영합니다 🎉");
		} else {
			System.out.println("회원 등록 실패");
		}
	}
	
	//마이페이지 : 내정보조회
	public void mypageMemberInfo() {
		System.out.println("✔ 내 정 보 조 회 ✔");
		
		List<Member> list = MemberDAO.getInstance().mypageMemberInfo();
		for(int i = 0; i<list.size(); i++) {
			System.out.println();
			System.out.println("아이디 : " + list.get(i).getMemberId());
			System.out.println("이름 : " + list.get(i).getMemberName());
			System.out.println("연락처 : " + list.get(i).getMemberPhone());
			System.out.println("주소 : " + list.get(i).getMemberAddr());
			System.out.println("생년월일 : " + list.get(i).getMemberBirth());
			System.out.println("회원등록일 : " + list.get(i).getMemberJoin());
		}	
	}
	
	//내정보관리 : 비밀번호 수정
		public void modifyPw() {
			Member member = new Member();
			System.out.println("🔑변경하실 비밀번호를 입력해주세요.");
			member.setMemberPw(sc.nextLine());
			
			int result = MemberDAO.getInstance().modifyPw(member);
			if(result > 0) {
				System.out.println("👌 비밀번호가 변경되었습니다.");
			}else {
				System.out.println("🤞 비밀번호 변경이 실패하였습니다.");
			}
		}
	
	
	//내정보관리 : 연락처수정
	public void modifyPhone() {
		Member member = new Member();
		System.out.println("☎변경하실 연락처를 입력해주세요.");
		member.setMemberPhone(sc.nextInt());
		
		int result = MemberDAO.getInstance().modifyPhone(member);
		if(result > 0) {
			System.out.println("-----------------------");
			System.out.println("👌 연락처가 변경되었습니다.");
		}else {
			System.out.println("-----------------------");
			System.out.println("🤞 연락처 변경이 실패하였습니다.");
		}
	}
	
	//내정보관리 : 주소수정
	public void modifyAddr() {
		Member member = new Member();
		System.out.println("📭변경하실 주소를 입력해주세요.");
		member.setMemberAddr(sc.nextLine());
		
		int result = MemberDAO.getInstance().modifyAddr(member);
		if(result > 0) {
			System.out.println("-----------------------");
			System.out.println("👌 주소가 변경되었습니다.");
		}else {
			System.out.println("-----------------------");
			System.out.println("🤞 주소 변경이 실패하였습니다.");
		}
	}
	
	
}
