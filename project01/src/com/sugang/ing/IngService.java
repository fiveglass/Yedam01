package com.sugang.ing;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class IngService {
	Scanner sc = new Scanner(System.in);
	
	//마이페이지 :  수강내역조회
	public void mypageStudying() {
		System.out.println("✔ 수 강 내 역 조 회 ✔");
		
		List<Ing> list = IngDAO.getInstance().mypagestudying();
		System.out.println(list.get(1).getMemberId() + "의 수강내역");
		for(int i = 0; i<list.size(); i++) {
			System.out.print("| 강의번호 : " + list.get(i).getClassNo());
			System.out.println(" | 강의명 : " + list.get(i).getClassName());
		}
	}
	
	
	//내정보관리 : 수강취소
		public void deleteStudying() {
			List<Ing> list = IngDAO.getInstance().mypagestudying();
			if(list.size() == 0) {
				System.out.println("📒나의 수강내역");
				System.out.println("수강 중인 강좌가 없습니다.");
			}else {
				System.out.println("📒나의 수강내역");
				for(int i = 0; i<list.size(); i++) {
					System.out.print("| 강의번호 : " + list.get(i).getClassNo());
					System.out.println(" | 강의명 : " + list.get(i).getClassName());
				}
				System.out.println("-----------------------------");
				System.out.println("수강 취소 할 강좌번호를 입력하세요.");
				int classno = Integer.parseInt(sc.nextLine());
				
				Ing ing = IngDAO.getInstance().refundClass(classno);
				
				LocalDate date = LocalDate.now();
				
				int year = 2023, month=1, dayOfMonth=1;
				LocalDate date1  = LocalDate.of(year, month, dayOfMonth);
				
				
				if(ing.getClassSemester().equals("1학기")) {
					
					if(date.isBefore(date1.plusMonths(1)) ) {
						System.out.println("수강 취소 시 환불금액은" + ing.getIngTuition()/2 + "원 입니다.");
					}else if(date.isBefore(date1.plusMonths(2)) ){
						System.out.println("수강 취소 시 환불금액은" + ing.getIngTuition()/4 + "원 입니다.");
					}else {
						System.out.println("수강 취소 시 환불금액은 0원 입니다.");
					}
				}
				
				int result = IngDAO.getInstance().deleteStudying(classno);
				
				if(result > 0) {
					System.out.println("👌수강취소 완료");
				}else {
					System.out.println("🤞수강취소 실패");
				}
			}
		}
		
		
}
