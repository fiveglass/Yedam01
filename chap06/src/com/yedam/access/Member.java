package com.yedam.access;

public class Member {
	//어떠한 사이트에 회원정보를 저장
	//아이디, 비밀번호, 이름, 나이
	private String id;
	private String pw;
	private String name;
	private int age;
	
	//생성자 기본 생성자
	
	//getter, setter 활용하여 정보 읽고 저장
	public void setid (String id) {
		this.id = id;
	}
	public String getid() {
		return id;
	}
	public void setpw (String pw) {
		this.pw = pw;
	}
	public String getpw() {
		return pw;
	}
	public void setname (String name) {
		this.name = name;
	}
	public String getname() {
		return name;
	}
	//1)나이를 입력 받았을 때 0보다 작은 숫자가 들어오면 0으로 바꿔준다
	public void setage (int age) {
		this.age = (age < 0) ? 0 : age;
	}
	//2)나이정보를 얻어갈 떄는 +1해서 얻어간다
	public int getage() {
		return ++age;
	}
	
}
