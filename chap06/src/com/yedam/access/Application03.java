package com.yedam.access;

public class Application03 {

	public static void main(String[] args) {
		//하나의 객체를 외부로 전달하는 상황
		Singleton s1=Singleton.getInstance();
		
		Singleton s2=Singleton.getInstance();
		
		//객체의 주소가 같음을 확인하여서 같은 객체인지 확인하는 방법
		System.out.println(s1 == s2);
		
		s1.age=100;
		s1.name="고길동";
		
		System.out.println(s2.age);
		System.out.println(s2.name);
	}

}
