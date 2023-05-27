package com.sugang.manager;

import java.util.List;
import java.util.Scanner;

import com.sugang.cart.Cart;
import com.sugang.clas.Clas;
import com.sugang.ing.Ing;
import com.sugang.member.Member;
import com.sugang.utils.pageMenu;

public class ManagerService {
	
	Scanner sc = new Scanner(System.in);
	
	private int page = 1;
	
	public ManagerService() {
		
	}
	
	//회원조회 : 전체조회
	public void getMemberList() {
		String plusQuery = "member";
		int count = ManagerDAO.getInstance().getCount(plusQuery);
		int lastPage = count/5;
		lastPage = count%5 > 0 ? lastPage+1 : lastPage;
		if(page == 0) {
			page = 1;
			return;
		}
		List<Member> list = ManagerDAO.getInstance().getMemberList(page);
		System.out.printf("🚻 전체회원조회 : 총 %d 명\n", count);
		System.out.println("============================================================================================================");
		if (list.size() == 0) {
			System.out.println("| 정보가 입력이 되어 있지 않습니다.");
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.print("| 아이디 : " + list.get(i).getMemberId() + "\t");
				System.out.print(" | 이름 : " + list.get(i).getMemberName() + "\t");
				System.out.print(" | 연락처 : " + list.get(i).getMemberPhone() + "\t");
				System.out.print(" | 주소 : " + list.get(i).getMemberAddr() + "\t");
				System.out.print(" | 생년월일 : " + list.get(i).getMemberBirth() + "\t");
				System.out.println(" | 회원등록일 : " + list.get(i).getMemberJoin());
			}
			System.out.println("============================================================================================================");
			System.out.printf("                   %d/%d pages\n" , page, lastPage);
			
			page = pageMenu.getPageMenu(page, sc, plusQuery);
			getMemberList();
		}	
	}
	
	//수강내역관리 : 수강신청내역
	public void completeCartList() {
		String plusQuery = "Cart";
		int count = ManagerDAO.getInstance().getCount(plusQuery);
		int lastPage = count/5;
		lastPage = count%5 > 0 ? lastPage+1 : lastPage;
		if(page == 0) {
			page = 1;
			return;
		}
		List<Cart> list = ManagerDAO.getInstance().completeCartList(page);
		System.out.printf("🚻 수강신청내역조회 : 총 %d 건\n", count);
		System.out.println("============================================================================================================");
		if (list.size() == 0) {
			System.out.println("| 정보가 입력이 되어 있지 않습니다.");
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.print((i+1) + ". ");
				System.out.print("| 아이디 : " + list.get(i).getMemberId() + "\t");
				System.out.print(" | 강좌번호 : " + list.get(i).getClassNo() + "\t");
				System.out.println(" | 강좌명 : " + list.get(i).getClassName() + "\t");
			}
			System.out.println("============================================================================================================");
			System.out.printf("                   %d/%d pages\n" , page, lastPage);
			
			page = pageMenu.getPageMenu(page, sc, plusQuery);
			completeCartList();
		}
	}
	
	
	//회원조회 : 강좌로 조회 메뉴
	public int inputClassNo() {
		System.out.println("🧾강좌번호를 입력하여 해당 강좌 수강생 확인");
		int classNo = Integer.parseInt(sc.nextLine());
		
		return classNo;
	}
	
	//회원조회 : 강좌로 조회
	public void referClass(int classNo) {
		String plusQuery = "ing i join member m on i.member_id = m.member_id\r\n"
				+ "where i.class_no = ";
		plusQuery = plusQuery + String.valueOf(classNo);
		
		int count = ManagerDAO.getInstance().getCount(plusQuery);
		int lastPage = count/5;
		lastPage = count%5 > 0 ? lastPage+1 : lastPage;
		if(page == 0) {
			page = 1;
			return;
		}
		List<Ing> list = ManagerDAO.getInstance().referClass(page, classNo);
		System.out.println("============================================================================================================");
		System.out.printf("🚻 해당 강좌 수강생 : 총 %d 명\n", count);
		if(list.size()==0) {
			System.out.println("조회할 정보가 없습니다.");
		}else {
			for(int i = 0; i<list.size(); i++) {	
				System.out.print("| 강좌이름 : " + list.get(i).getClassName());
				System.out.print(" | 아이디 : " + list.get(i).getMemberId());
				System.out.print(" | 이름 : " + list.get(i).getMemberName());
				System.out.println(" | 연락처 : " + list.get(i).getMemberPhone());
			}
			System.out.println("============================================================================================================");
			System.out.printf("                   %d/%d pages\n" , page, lastPage);

			page = pageMenu.getPageMenu(page, sc, plusQuery);
			referClass(classNo);
		}
	}

	
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
