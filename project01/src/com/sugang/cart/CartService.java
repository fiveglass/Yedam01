package com.sugang.cart;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.sugang.clas.Clas;

public class CartService {
	Scanner sc = new Scanner(System.in);
	
	//수강꾸러미 : 수꾸
	public void CartIndex() {
		LocalDate date = LocalDate.now();
		String semester = null;
		
		LocalDate midDate  = LocalDate.of(2023, 7, 1);
		
		if(date.isBefore(midDate)) {
			semester = "1학기";
		}else if(date.isAfter(midDate)) {
			semester = "2학기";
		}
		System.out.println("🗂강좌리스트");
		List<Clas> list = CartDAO.getInstance().CartIndex(semester);
		for(int i = 0; i < list.size(); i++) {
			System.out.print("📖 강좌번호 :" + list.get(i).getClassNo());
			System.out.print(" , 강좌명 :" + list.get(i).getClassName()); 
			System.out.print(" , 선생님 :" + list.get(i).getClassTeacher());
			System.out.print(" , 강의날 : " + list.get(i).getClassDate());
			System.out.print(" , 정원 : " + list.get(i).getClassLimit());
			System.out.println(" , 현인원 : " + list.get(i).getClassNumber());

		}
		System.out.println("📂수강꾸러미에 담을 강좌번호를 입력해주세요.");
		int classNo = Integer.parseInt(sc.nextLine());
		List<Clas> list1 = CartDAO.getInstance().applyCheck(classNo);
		Clas cs = CartDAO.getInstance().dateCheck(classNo);
		
		for(int i = 0; i < list1.size(); i++) {
			if(list.get(i).getClassNo()==cs.getClassNo()) {
				System.out.println("😭동일한 과목은 담을 수 없습니다.");
			}else if(list.get(i).getClassDate().equals(cs.getClassDate())) {
				System.out.println("😭동일한 요일의 강좌를 중복 신청할 수 없습니다.");
			}else {
				int result = CartDAO.getInstance().applyClass(classNo);
				
				if(result > 0) {
					System.out.println("🗂수강꾸러미에 담겼습니다.");
				} else {
					System.out.println("수강꾸러미 등록 실패");
				}
			}
		}
	
		
	}
	
	
	//수강꾸러미 : 수강신청내역
	public void applyStory() {
		System.out.println("✔ 수 강 신 청 조 회 ✔");
		
		List<Cart> list = CartDAO.getInstance().applyStory();
		System.out.println("------------------------");
		for(int i = 0; i<list.size(); i++) {
			System.out.print((i+1) + ". | 강의번호 : " + list.get(i).getClassNo());
			System.out.println(" | 강의명 : " + list.get(i).getClassName());
		}
	}
}
