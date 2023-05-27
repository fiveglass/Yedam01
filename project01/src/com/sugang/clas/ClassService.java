package com.sugang.clas;

import java.util.List;
import java.util.Scanner;

import com.sugang.manager.ManagerDAO;
import com.sugang.utils.pageMenu;

public class ClassService {
	
	Scanner sc = new Scanner(System.in);
	
	private int page = 1;
	
	public ClassService() {
		
	}
	
	//강좌조회 : 강좌목록 조회 메뉴
	public String inputClassSemester() {
		System.out.println("🔎조회하고 싶은 학기를 입력해주세요.");
		String classSemester = sc.nextLine();
		
		return classSemester;
	}
	
	//강좌조회 : 강좌목록
	public void classIndex(String classSemester) {
		String plusQuery = "class WHERE class_semester =";
		plusQuery = plusQuery + "\'" + classSemester + "\'";
		
		int count = ManagerDAO.getInstance().getCount(plusQuery);
		int lastPage = count/5;
		lastPage = count%5 > 0 ? lastPage+1 : lastPage;
		if(page == 0) {
			page = 1;
			return;
		}
		
		List<Clas> list = ClassDAO.getInstance().classIndex(page, classSemester);
		System.out.printf("| '" + classSemester +" 강좌목록 : 총 %d 개\n", count);
		System.out.println("============================================================================================");
		if(list.size() == 0) {
			System.out.println("해당학기 수업은 존재하지 않습니다.");
		}else {
			for(int i = 0; i < list.size(); i++) {
				System.out.print("📖 강좌번호 :" + list.get(i).getClassNo()+"\t"); 
				System.out.print("| 강좌명 :" + list.get(i).getClassName()+"\t"); 
				System.out.print("| 선생님 :" + list.get(i).getClassTeacher()+"\t");
				System.out.print("| 정원 : " + list.get(i).getClassLimit()+"\t");
				System.out.print("|  현인원 : " + list.get(i).getClassNumber()+"\t");
				System.out.println("| 강의날 : " + list.get(i).getClassDate());
			}
			System.out.println("============================================================================================");
			System.out.printf("                   %d/%d pages\n" , page, lastPage);
			
			page = pageMenu.getPageMenu2(page, sc, plusQuery);
			classIndex(classSemester);	
		}
		
	}
}
