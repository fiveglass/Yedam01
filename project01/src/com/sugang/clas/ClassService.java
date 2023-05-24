package com.sugang.clas;

import java.util.List;
import java.util.Scanner;

public class ClassService {
	Scanner sc = new Scanner(System.in);
	
	//강좌조회 : 강좌목록
	public void classIndex() {
		System.out.println("🔎조회하고 싶은 학기를 입력해주세요.");
		String classSemester = sc.nextLine();
		System.out.println("| '" + classSemester +" 강좌목록");
		System.out.println("=======================================");
		List<Class> list = ClassDAO.getInstance().classIndex(classSemester);
		if(list.size() == 0) {
			System.out.println("해당학기 수업은 존재하지 않습니다.");
		}else {
			for(int i = 0; i < list.size(); i++) {
				System.out.print("📖 강좌번호 :" + list.get(i).getClassNo());
				System.out.print(" , 강좌명 :" + list.get(i).getClassName()); 
				System.out.print(" , 선생님 :" + list.get(i).getClassTeacher());
				System.out.print(" , 정원 : " + list.get(i).getClassLimit());
				System.out.print(" , 현인원 : " + list.get(i).getClassNumber());
				System.out.println(" , 강의날 : " + list.get(i).getClassDate());
			}
			System.out.println("=======================================");
			System.out.println("🔎 강의 내용을 확인하고 싶다면 강좌번호를 입력해주세요");
			System.out.println("📌 0. 뒤로가기 ");
			int classno = Integer.parseInt(sc.nextLine());//입력한 값이 엔터인지 판단
			
			if(classno == 0) {
				return;
			}else {
				Class cs = ClassDAO.getInstance().indexContent(classno);
				if(cs != null) {
					System.out.println("🔎" + cs.getClassName() + "'의 강의 내용");
					System.out.println(cs.getClassExplain());
				}else {
					System.out.println("조회정보없음");
				}	
			}
			
		}
		
	}
}
