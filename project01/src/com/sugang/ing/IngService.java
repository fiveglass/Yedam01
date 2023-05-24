package com.sugang.ing;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
				int classno = sc.nextInt();
				
				Ing ing = IngDAO.getInstance().refundClass(classno);
				
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date semester1 = formatter.parse("2023-01-01");
				Date semester2 = formatter.parse("2023-04-01");
				Date semester3 = formatter.parse("2023-07-01");
				Date semester4 = formatter.parse("2023-10-01");
				Date startdate = new Date();
				if(ing.getClassSemester().equals("1학기")) {
					startdate = semester1;
					if(formatter.after(semester1, 1)) {
						
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
