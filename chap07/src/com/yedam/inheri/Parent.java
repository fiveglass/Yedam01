package com.yedam.inheri;

public class Parent {
	//필드
	String lastName;
	
	//생성자
	
	//메소드
	public void getInfo() {
		System.out.println("우리 가족의 성은?" + lastName);
	}
	public void method1() {
		System.out.println("부모객체 메소드1 실행");
	}
	public void method2() {
		System.out.println("부모객체 메소드2 실행");
	}
}
