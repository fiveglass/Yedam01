package com.yedam.member;

import java.util.List;
import java.util.Scanner;

public class MemberService {
	//member의 정보를 자바 프로그램 전역에서 공유 & 사용 = static
	public static Member memberInfo = null;
	
	Scanner sc =new Scanner(System.in);
	
	public void login() {
		Member member = null;
		System.out.println("ID>");
		String id = sc.nextLine();
		
		System.out.println("PW>");
		String pw = sc.nextLine();
		
		//회원 정보 조회
		member = MemberDAO.getInstance().login(id);
		//Java를 활용 -> 경우의 수를 여러 개
		//입력한 id를 통해 회원 정보를 조회, 조회 된 결과에 따라서 login 여부를 결정
		//1. id를 통해 조회 -> 회원의 정보 존재
		//입력한 비밀번호와 조회한 회원의 정보에서 비밀번호가 동일 => login
		//memberInfo에 조회한 정보를 입력
		
		//2. id를 통해 조회 X -> 회원의 정보가 X 및 id가 틀렸다.
		//login 실패, memberInfo를 null로 유지
		
		//======================================================
		//DB를 활용
		//쿼리문
		//SELECT * FROM member WHERE member_id =? AND member_pw =?
		//조회 된 결과 -> 데이터 O or 데이터 X
		//데이터 O -> Id/PW -> Login
		//데이터 X -> Id or Pw가 틀렸다.
		if(member != null) { //데이터가 존재 == 입력한 id가 맞다
			if(member.getMemberPw().equals(pw)) {
				System.out.println("정상 로그인되었습니다.");
				System.out.println(member.getMemberId()+"님 환영합니다.🎉🎉");
				//조회된 정보를 전역에서 사용할 수 있게끔 데이터를 입력
				memberInfo = member;
			}else {
				System.out.println("비밀번호가 틀립니다.😥😥");
			}
		}else {
			System.out.println("아이디가 존재하지 않습니다.😥😥");
		}
	}
	
	//회원가입
	public void insertMember() {
		System.out.println("🎈🎈 회 원 가 입 🎈🎈");
		String id = "";
		while(true) {
			System.out.println("ID>");
			id = sc.nextLine();
			Member member = MemberDAO.getInstance().login(id);
			if(member != null) {
				System.out.println("존재하는 ID 입니다.");
			}else if(member == null) {
				System.out.println("사용가능한 ID 입니다.");
				break;
			}
		}
		System.out.println("PW>");
		String pw = sc.nextLine();
		
		System.out.println("Phone>");
		String phone = sc.nextLine();
		
		System.out.println("Address>");
		String addr = sc.nextLine();
		
		Member mem = new Member();
		mem.setMemberId(id);
		mem.setMemberPw(pw);
		mem.setMemberPhone(phone);
		mem.setMemberAddr(addr);
		
		int result = MemberDAO.getInstance().insertMember(mem);
		
		if(result > 0) {
			System.out.println("# 회원 가입 축하 🎊");
			//memberInfo = MemberDAO.getInstance().login(id);
		}else {
			System.out.println("회원 가입 실패");
		}
	}
	
	public void logout() {
		memberInfo = null;
		System.out.println("로그아웃 완료😎😎");
	}
	
	public void confirmInfo() {
		System.out.println("회원 정보 조회");
		Member member = MemberDAO.getInstance().login(memberInfo.getMemberId());
		System.out.println("ID : " + member.getMemberId());
		System.out.println("PW : " + member.getMemberPw());
		System.out.println("Phone : " + member.getMemberPhone());
		System.out.println("Addr : " + member.getMemberAddr());
		System.out.println("Grade : " +(member.getMemberGrade().equals("N") ? "일반사용자" : "관리자"));
	}
	
	//전체 조회
	public void getMemberList() {
		List<Member> list = MemberDAO.getInstance().getMemberList();
		System.out.println("전체 회원 조회🤩🤩");
		for(int i = 0; i<list.size(); i++) {
			System.out.println("ID : " + list.get(i).getMemberId());
			System.out.println("PW : " + list.get(i).getMemberPw());
			System.out.println("Phone : " + list.get(i).getMemberPhone());
			System.out.println("Addr : " + list.get(i).getMemberAddr());
			System.out.println("Grade : " + (list.get(i).getMemberGrade().equals("N") ? "일반사용자" : "관리자"));
			System.out.println("=====================================");
		}
	}
	
	//연락처 수정
	public void updatePhone() {
		System.out.println("연락처 수정📞📞");
		
		Member member = new Member();
		
		System.out.println("ID >");
		String id = sc.nextLine();
		String phone = "";
		while(true) {
			System.out.println("연락처 >");
			phone = sc.nextLine();
			if(phone.length() > 13) {
				System.out.println("자리수 초과 => 13자리수 미만 입력🤬🤬");
			}else {
				System.out.println("연락처 확인 완료");
				break;
			}
		}
		member.setMemberId(id);
		member.setMemberPhone(phone);
		int result = MemberDAO.getInstance().updatePhone(member);
		
		if(result > 0) {
			System.out.println("연락처 수정 완료");
		}else {
			System.out.println("연락서 수정 실패");
		}
	}
	
	//회원정보 삭제
	public void deleteMember() {
		System.out.println("# 회원 정보 삭제");
		System.out.println("ID>");
		String id = sc.nextLine();
		
		int result = MemberDAO.getInstance().deleteMember(id);
		
		if(result > 0) {
			System.out.println("회원 정보 삭제 완료");
		}else {
			System.out.println("회원 정보 삭제 실패");
		}
	}
	
	
	
	
	
	
	
	
	
	
}
