package com.yedam.access;

public class Singleton {
//	//클래스 내부에서 하나의 객체 생성
//	//이때, 하나의 객체는 외부에서 접근 불가능
//	private static Singleton singleton = new Singleton();
//	
//	//외부에서 객체를 생성하지 못하도록 막는 역할
//	private Singleton() {
//		
//	}
//	
//	
//	//클래스 내부에서 만든 단 하나의 객체를 외부에 전달하기 위해서(5줄 참고)
//	public static Singleton getInstance () {
//		return singleton;
//	}
	
//	public void info() {
//		System.out.println("인스턴스 메소드 info 출력");
//	}
	
	//필드
	public String name;
	public int age;

	
	//클래스 내부에서 하나의 객체 생성
	//이때, 하나의 객체는 외부에서 접근 불가능
	private static Singleton singleton = null;
	
	//외부에서 객체를 생성하지 못하도록 막는 역할
	private Singleton() {
		
	}
	
	
	//클래스 내부에서 만든 단 하나의 객체를 외부에 전달하기 위해서(5줄 참고)
	public static Singleton getInstance () {
		if(singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}
}
