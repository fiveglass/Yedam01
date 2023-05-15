package com.yedam.inheri;

public class Child extends Parent {
	//필드
	String Name;
	
	@Override
	public void getInfo() {
		System.out.println("자식객체 메소드1실행");
	 }
	public void method3() {
		 System.out.println("자식객체 메소드3실행");
	}
}
