package com.sugang.exe;

import java.util.Scanner;

import com.sugang.board.BoardService;
import com.sugang.cart.CartService;
import com.sugang.clas.ClassService;
import com.sugang.ing.IngService;
import com.sugang.member.MemberService;

public class MemberApp {
	Scanner sc = new Scanner(System.in);
	MemberService ms = new MemberService();
	IngService ing = new IngService();
	ClassService cs = new ClassService();
	CartService cts = new CartService();
	BoardService bs = new BoardService();
	
	public MemberApp() {
		memberGo();
	}
	
	private void memberGo() {
		boolean run = true;
		while(run) {
			memberMenu();
			String selectNo = sc.nextLine();
			switch (selectNo) {
			case "1" :
				System.out.println("🔒 마 이 페 이 지 🔒------------예담복지관");
				System.out.println("1.내정보 조회 | 2.수강내역 조회 | 3.뒤로가기");
				selectNo = sc.nextLine();
				if(selectNo.equals("1")) {
					ms.mypageMemberInfo();
				}else if(selectNo.equals("2")){
					ing.mypageStudying();
				}else {
					run=false;
				}
				break;
			case "2" :
				System.out.println("⚙ 내 정 보 관 리 ⚙--------------------------------예담복지관");
				System.out.println("1.비밀번호수정 | 2.연락처수정 | 3.주소수정 | 4.수강취소 | 5.뒤로가기");
				selectNo = sc.nextLine();
				if(selectNo.equals("1")) {
					ms.modifyPw();				
				}else if(selectNo.equals("2")) {
					ms.modifyPhone();				
				}else if(selectNo.equals("3")){
					ms.modifyAddr();
				}else if(selectNo.equals("4")) {
					ing.deleteStudying();
				}else {
					run=false;
				}
				break;
			case "3" : 
				System.out.println("🛒수 강 꾸 러 미 🛒-------------------------예담복지관");
				System.out.println("1.수강신청 | 2.수강신청꾸러미 | 3.수강신청내역 | 4.뒤로가기");
				selectNo = sc.nextLine();
				if(selectNo.equals("1")) {
					cts.apply();			
				}else if(selectNo.equals("2")) {
					cts.CartIndex();			
				}else if(selectNo.equals("3")) {
					cts.applyStory();
				}else {
					run=false;
				}
				break;
			case "4" : 
				System.out.println("🗂 강 좌 조 회 🗂------예담복지관");
				System.out.println("1.강좌목록 및 상세보기 | 2.뒤로가기");
				selectNo = sc.nextLine();
				if(selectNo.equals("1")) {
					String classSemester = cs.inputClassSemester();
					cs.classIndex(classSemester);			
				}else {
					run=false;
				}
				break;
			case "5" :
				bs.memberBoardList();
				break;
			case "6" : 
				MemberService.memberInfo = null;
				run=false;
				break;
			}
		}
	}
	
	public void memberMenu() {
		System.out.println();
		System.out.println("🙌 예 담 종 합 사 회 복 지 관 회 원 시 스 템 ----------------------------회원용");
		System.out.println("1.마이페이지 | 2.내정보관리 | 3.수강꾸러미 | 4.강좌조회 | 5.회원게시판 | 6.로그아웃");
		System.out.println("------------------------------------------------------------------------");
	}
}
