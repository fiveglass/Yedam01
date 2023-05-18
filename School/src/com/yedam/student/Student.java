package com.yedam.student;

public class Student {
//	std_id number primary key,
//	std_name varchar2(9) not null,
//	std_major varchar2(18),
//	std_point number
	private int stdId;
	private String stdName;
	private String stdMajor;
	private int stdPoint;
	
	public int getStdId() {
		return stdId;
	}
	public void setStdId(int stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdMajor() {
		return stdMajor;
	}
	public void setStdMajor(String stdMajor) {
		this.stdMajor = stdMajor;
	}
	public int getStdPoint() {
		return stdPoint;
	}
	public void setStdPoint(int stdPoint) {
		this.stdPoint = stdPoint;
	}
	
}
