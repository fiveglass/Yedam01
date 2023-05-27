package com.sugang.exe;

import java.util.Scanner;

import com.sugang.manager.ManagerService;

public class ManagerApp {
	
	Scanner sc = new Scanner(System.in);
	ManagerService mns = new ManagerService();
	
	public ManagerApp() {
		managerGo();
	}
	
	private void managerGo() {
		boolean run = true;
		while(run) {
			managerMenu();
			String selectNo = sc.nextLine();
			switch (selectNo) {
			case "1" :
				System.out.println("*** *** 회 원 조 회 *** ***");
				System.out.println("1.전체 수강생 조회 | 2.전화번호로 조회 | 3.이름으로 조회 | 4.강좌로 조회 | 5.뒤로가기");
				selectNo = sc.nextLine();
				if(selectNo.equals("1")) {
					mns.getMemberList();
				}else if (selectNo.equals("2")) {
					mns.referPhone();
				}else if (selectNo.equals("3")) {
					mns.referName();
				}else if (selectNo.equals("4")) {
					int classNo = mns.inputClassNo();
					mns.referClass(classNo);
				}else {
					run=false;
				}
				break;
			case "2" :
				System.out.println("*** *** 회 원 관 리 *** ***");
				System.out.println("1.연락처 수정 | 2.회원 삭제 | 3.관리자계정생성 | 4.뒤로가기");
				selectNo = sc.nextLine();
				if(selectNo.equals("1")) {
					mns.updatePhone();
				}else if (selectNo.equals("2")) {
					mns.deleteMemder();
				}else if(selectNo.equals("3")) {
					mns.membership();
				}else {
					run=false;
				}
				break;
			case "3" :
				System.out.println("*** *** 강 좌 관 리 *** ***");
				System.out.println("1.강좌등록 | 2.강좌수정 | 3.강좌삭제 | 4.뒤로가기");
				selectNo = sc.nextLine();
				if(selectNo.equals("1")) {
					mns.insertClass();
				}else if (selectNo.equals("2")) {
					mns.modifyClass();
				}else if (selectNo.equals("3")) {
					mns.deleteClass();
				}else {
					run=false;
				}
				break;	
			case "4" :
				System.out.println("*** *** 수 강 내 역 관 리 *** ***");
				System.out.println("1.수강 신청 내역 | 2.뒤로가기");
				selectNo = sc.nextLine();
				if(selectNo.equals("1")) {
					mns.completeCartList();
				}else {
					run=false;
				}
				break;	
 			}
		}
	}
	
	
	
	
	public void managerMenu() {
		System.out.println("1.회원조회 | 2.회원관리 | 3.강좌관리 | 4.수강내역관리");
	}
}
