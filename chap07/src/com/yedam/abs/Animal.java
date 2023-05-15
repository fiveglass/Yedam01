package com.yedam.abs;
//추상클래스
public abstract class Animal {
	//필드
	public String kind;
	//생성자
	
	//메소드
	public void breath() {
		System.out.println("숨");
	}
	//추상메소드
	public abstract void sound();
	
}
