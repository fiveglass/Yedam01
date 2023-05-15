package com.yedam.inheri;

public class Student extends People{
	public int stdNo;
	
	public Student(String name, String ssn, int stdNo) {
		super(name, ssn);
		this.stdNo = stdNo;
	}
}
