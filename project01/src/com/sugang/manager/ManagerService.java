package com.sugang.manager;

import java.util.List;
import java.util.Scanner;

import com.sugang.clas.Clas;
import com.sugang.member.Member;
import com.sugang.member.MemberDAO;

public class ManagerService {
	
	Scanner sc = new Scanner(System.in);
	
	//회원조회 : 전화번호 조회
	public void referPhone() {
		System.out.println("📞전화번호로 회원조회");
		int memberPhone = Integer.parseInt(sc.nextLine());
		
		List<Member> list = ManagerDAO.getInstance().referPhone(memberPhone);
		if(list.size()==0) {
			System.out.println("조회할 정보가 없습니다.");
		}else {
		for(int i = 0; i<list.size(); i++) {
			System.out.print("| 아이디 : " + list.get(i).getMemberId());
			System.out.print(" | 이름 : " + list.get(i).getMemberName());
			System.out.print(" | 연락처 : " + list.get(i).getMemberPhone());
			System.out.print(" | 주소 : " + list.get(i).getMemberAddr());
			System.out.print(" | 생년월일 : " + list.get(i).getMemberBirth());
			System.out.println(" | 회원등록일 : " + list.get(i).getMemberJoin());
		}
		}
	}
	
	//회원조회 : 이름 조회
	public void referName() {
		System.out.println("😊이름으로 회원조회");
		String memberName = sc.nextLine();
		
		List<Member> list = ManagerDAO.getInstance().referName(memberName);
		if(list.size()==0) {
			System.out.println("조회할 정보가 없습니다.");
		}else {
		for(int i = 0; i<list.size(); i++) {
			System.out.print("| 아이디 : " + list.get(i).getMemberId());
			System.out.print(" | 이름 : " + list.get(i).getMemberName());
			System.out.print(" | 연락처 : " + list.get(i).getMemberPhone());
			System.out.print(" | 주소 : " + list.get(i).getMemberAddr());
			System.out.print(" | 생년월일 : " + list.get(i).getMemberBirth());
			System.out.println(" | 회원등록일 : " + list.get(i).getMemberJoin());
		}	
		}
	}
	
	//회원관리 : 연락처수정
	public void updatePhone() {
		Member member = new Member();
		System.out.println("변경하실 회원의 아이디를 입력해주세요.");
		member.setMemberId(sc.nextLine());
		System.out.println("변경할 연락처를 입력해주세요.");
		member.setMemberPhone(sc.nextInt());
		
		int result = ManagerDAO.getInstance().updatePhone(member);
		
		if(result > 0){
			System.out.println("👌 연락처가 변경되었습니다.");
		}else {
			System.out.println("🤞 연락처 변경이 실패하였습니다.");
		}
	}
	
	//회원관리 : 회원삭제
	public void deleteMemder() {
		System.out.println("삭제하실 회원의 아이디를 입력해주세요.");
		String memberId = sc.nextLine();
		int result = ManagerDAO.getInstance().deleteMember(memberId);
		if(result > 0) {
			System.out.println("👌 회원이 삭제되었습니다.");
		}else {
			System.out.println("🤞 회원 삭제 실패하였습니다.");
		}
		
	}
	
	//회원관리 : 관리자 계정 생성
	public void membership() {
		Member member = new Member();
		System.out.println("*** *** 관 리 자 등 록 *** ***");
		
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
		
		int result = ManagerDAO.getInstance().membership(member);
		
		if(result > 0) {
			System.out.println("관리자 등록");
		} else {
			System.out.println("관리자 등록 실패");
		}
	}
	
	//강좌관리 : 강좌등록
	public void insertClass() {
		Clas cs = new Clas();
		System.out.println("===========================");
		System.out.println("| 강좌번호");
		cs.setClassNo(Integer.parseInt(sc.nextLine()));
		
		System.out.println("| 강좌명 >");
		cs.setClassName(sc.nextLine());
		
		System.out.println("| 선생님 >");
		cs.setClassTeacher(sc.nextLine());
		
		System.out.println("| 정원 >");
		cs.setClassLimit(Integer.parseInt(sc.nextLine()));
		
		System.out.println("| 현인원 >");
		cs.setClassNumber(Integer.parseInt(sc.nextLine()));
		
		System.out.println("| 강의요일 >");
		cs.setClassDate(sc.nextLine());
		
		System.out.println("| 학기 >");
		cs.setClassSemester(sc.nextLine());
		
		System.out.println("| 강의 내용 >");
		cs.setClassExplain(sc.nextLine());
		
		int result = ManagerDAO.getInstance().insertClass(cs);
		
		if(result > 0) {
			System.out.println("👌 강의가 등록되었습니다.");
		}else {
			System.out.println("🤞 강의 등록을 실패하였습니다.");
		}
	}
	
	//강좌관리 : 강좌수정
	public void modifyClass() {
		Clas cs = new Clas();
		System.out.println("✏수정하고 싶은 강의번호를 입력해주세요.");
		int classNo = Integer.parseInt(sc.nextLine());
		System.out.println("✏수정하고 싶은 번호를 눌러주세요.");
		System.out.println("1.선생님 | 2.정원 | 3.날짜 | 4.학기 | 5.상세내용");
		int selectNo = Integer.parseInt(sc.nextLine());
		System.out.println("✏바꿀 내용을 입력해주세요.");
		String changeValue = sc.nextLine();
		
		int result = ManagerDAO.getInstance().modifyClass(selectNo, changeValue, classNo);
		
		if(result > 0) {
			System.out.println("👌 강의가 수정되었습니다.");
		}else {
			System.out.println("🤞 강의 수정을 실패하였습니다.");
		}
		
	}
	
	//강좌관리 : 강좌삭제
	public void deleteClass() {
		System.out.println("삭제할 강좌번호를 입력해주세요.");
		int classNo = Integer.parseInt(sc.nextLine());
		int result = ManagerDAO.getInstance().deleteClass(classNo);
		
		if(result > 0) {
			System.out.println("👌 강의가 삭제되었습니다.");
		}else {
			System.out.println("🤞 강의 삭제를 실패하였습니다.");
		}
	}
}
