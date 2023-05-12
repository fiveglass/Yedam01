package com.yedam.access;

public class Student {
	//이름, 학과, 학년, 과목별 점수
	private String stdName;
	private String major;
	private String stdGrade;
	private int programing;
	private int datebase;
	private int os;
	
	//생성자(기본생성자) 생략
	
	//메소드
	//setter 데이터 입력
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	
	public String getstdName() {
		return stdName;
	}
	
	public void setmajor(String major) {
		this.major = major;
	}
	
	public String getmajor() {
		return major;
	}
	
	public void setStdGrade(String stdGrade) {
		this.stdGrade = stdGrade;
	}
	
	public String getstdGrade() {
		return stdGrade;
	}
	//각 점수를 마이너스 시 0점으로 설정
	public void setprograming(int programing) {
		this.programing = (programing < 0) ? 0 : programing;
	}
	
	public int getprograming() {
		return programing;
	}
	
	public void setdatebase(int datebase) {
		this.datebase = (datebase < 0) ? 0 : datebase;
	}
	
	public int getdatebase() {
		return datebase;
	}
	
	public void setos(int os) {
		this.os = (os < 0) ? 0 : os;
	}
	
	public int getos() {
		return os;
	}

}
