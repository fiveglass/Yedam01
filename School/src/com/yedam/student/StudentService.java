package com.yedam.student;

import java.util.List;
import java.util.Scanner;

public class StudentService {
	Scanner sc = new Scanner(System.in);

	// 전체 학생 조회
	public void getStudentList() {
		List<Student> list = StudentDAO.getInstance().getStudentList();
		System.out.println("===========================");
		if (list.size() == 0) {
			System.out.println("| 정보가 입력이 되어 있지 않습니다.");
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.println("| " + "학번 :" + list.get(i).getStdId());
				System.out.println("| " + "이름 :" + list.get(i).getStdName());
				System.out.println("| " + "전공 : " + list.get(i).getStdMajor());
				System.out.println("| " + "점수 : " + list.get(i).getStdPoint());
			}
		}

	}

	// 단건 조회
	public void getStudent() {
		System.out.println("===========================");
		System.out.println("| 학번 입력>");
		int stdId = Integer.parseInt(sc.nextLine());

		Student std = StudentDAO.getInstance().getStudent(stdId);
		System.out.println("===========================");
		if (std != null) {
			System.out.println("| 학번 : " + std.getStdId());
			System.out.println("| 이름 : " + std.getStdName());
			System.out.println("| 전공 : " + std.getStdMajor());
			System.out.println("| 점수 : " + std.getStdPoint());
		} else {
			System.out.println("| 조회되는 정보가 없습니다.");
		}
	}
	// 학생 등록
	public void insetStd() {
		Student std = new Student();
		System.out.println("===========================");
		System.out.println("| 학번 >");
		std.setStdId(Integer.parseInt(sc.nextLine()));
		
		System.out.println("| 이름 >");
		std.setStdName(sc.nextLine());
		
		System.out.println("| 전공 >");
		std.setStdMajor(sc.nextLine());
		
		System.out.println("| 점수 >");
		std.setStdPoint(Integer.parseInt(sc.nextLine()));
		
		int result = StudentDAO.getInstance().insertStd(std);
		
		if(result > 0) {
			System.out.println("★ 학생 정보 입력 완료 ★");
		}else {
			System.out.println("▼ 학생 정보 입력 실패 ▼");
		}
	}
	// 학생 삭제
	public void deleteStd() {
		System.out.println("===========================");
		System.out.println("| 학번 >");
		int stdId = Integer.parseInt(sc.nextLine());
		int result = StudentDAO.getInstance().deleteStd(stdId);
		if(result > 0) {
			System.out.println("★ 학생 정보 삭제 완료 ★");
		}else {
			System.out.println("▼ 학생 정보 삭제 실패 ▼");
		}
	}
	// 전공 변경
	public void updateStd() {
		Student std = new Student();
		System.out.println("===========================");
		System.out.println("| 학번 >");
		std.setStdId(Integer.parseInt(sc.nextLine()));
		System.out.println("| 전공 >");
		std.setStdMajor(sc.nextLine());
		
		int result = StudentDAO.getInstance().modifyMajor(std);
		if(result > 0) {
			System.out.println("★ 학생 전공 수정 완료 ★");
		}else {
			System.out.println("▼ 학생 전공 수정 실패 ▼");
		}
	}
	
	//전공별 성적 합계, 평균 ->db에서 조회된 정보를 활용해서 만드는 방식
	//java(복잡도 up) : 전공확인, 배열 넣기, 전공별로 합계 또는 평균
	//데이터는 db에서 왠만하면 처리하고 java로 넘기는 것이 수월
	
	public void getAnalyze() {
		List<Student> list = StudentDAO.getInstance().getAnalyze();
		for(int i= 0;  i<list.size(); i++) {
			System.out.println("===========================");
			System.out.println("| 전공 : " + list.get(i).getStdMajor());
			System.out.println("| 합계 : " + list.get(i).getSum());
			System.out.println("| 평균 : " + list.get(i).getAvg());
			System.out.println("| 학생수 : " + (int)(list.get(i).getSum()/list.get(i).getAvg())+"명");
			
		}
	}
}

	
