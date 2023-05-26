package com.sugang.clas;

public class Clas {
	private int classNo;
	private String className;
	private String classTeacher;
	private int classLimit;
	private int classnumber;
	private String classDate;
	private String classSemester;
	private String classexplain;
	
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
	public String getClassTeacher() {
		return classTeacher;
	}
	public void setClassTeacher(String classTeacher) {
		this.classTeacher = classTeacher;
	}
	public int getClassLimit() {
		return classLimit;
	}
	public void setClassLimit(int classLimit) {
		this.classLimit = classLimit;
	}
	public int getClassNumber() {
		return classnumber;
	}
	public void setClassNumber(int number) {
		this.classnumber = number;
	}
	public String getClassDate() {
		return classDate;
	}
	public void setClassDate(String classDate) {
		this.classDate = classDate;
	}
	public String getClassSemester() {
		return classSemester;
	}
	public void setClassSemester(String classSemester) {
		this.classSemester = classSemester;
	}
	public String getClassExplain() {
		return classexplain;
	}
	public void setClassExplain(String explain) {
		this.classexplain = explain;
	}
	
	@Override
	public String toString() {
		return "Clas [classNo=" + classNo + ", className=" + className + ", classTeacher=" + classTeacher
				+ ", classLimit=" + classLimit + ", classnumber=" + classnumber + ", classDate=" + classDate
				+ ", classSemester=" + classSemester + ", classexplain=" + classexplain + "]";
	}
	
	
	
	
}
