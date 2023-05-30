package com.sugang.ing;

public class Ing {
	private int ingNo;
	private String memberId;
	private int classNo;
	private String className;
	private String classSemester;
	private int ingTuition;
	private int classNumber;
	
	public int getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}
	//강좌조회를 위한 새로운 필드선언
	private String memberName;
	private int memberPhone;
	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(int memberPhone) {
		this.memberPhone = memberPhone;
	}
	public int getIngNo() {
		return ingNo;
	}
	public void setIngNo(int ingNo) {
		this.ingNo = ingNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getClassNo() {
		return classNo;
	}
	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassSemester() {
		return classSemester;
	}
	public void setClassSemester(String classSemester) {
		this.classSemester = classSemester;
	}
	public int getIngTuition() {
		return ingTuition;
	}
	public void setIngTuition(int ingTuition) {
		this.ingTuition = ingTuition;
	}
	
	
	
}
