package com.yedam.oop;

public class Student {
	//학생들의 정보를 관리하는 객체
	//이름, 학년, 국어, 영어, 수학
	String name;
	int grade;
	int kor;
	int eng;
	int math;
	
	//기본 생성자
	Student(){}
	
	//모든 데이터를 받아오는 생성자
	Student(String name, int grade, int kor, int eng, int math){
		this.name = name;
		this.grade = grade;
		this.kor =kor;
		this.eng = eng;
		this.math = math;
	}
	
	//메소드
	//모든 정보를 출력 getInfo()
	void getInfo() {
		System.out.println(
				"학생정보" +
				"\n 1. 이름" + name +
				"\n 2. 학년" + grade +
				"\n 3. 국어" + kor +
				"\n 4. 영어" + eng +
				"\n 5. 수학" + math
				);
	}
}
