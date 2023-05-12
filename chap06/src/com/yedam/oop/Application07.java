package com.yedam.oop;

public class Application07 {
	//필드선언
	static int num = 1;
	//->정적멤버 : 객체 생성 없이 바로 사용할 수 있는 필드나 메소드
	//메소드선언
	static void info() {
		System.out.println("info 출력");
	}
	
	public static void main(String[] args) {
		info();
		//->이렇게 선언하기 위해서는 해당 메서드에 static(정적) 선언 해주기
		
		
	}
}
