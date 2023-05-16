package com.yedam.inter;

public class MyClassExample {

	public static void main(String[] args) {
		System.out.println("1.필드");
		
		Myclass myClass = new Myclass();
		
		//remotecontrol rc = new Television
		myClass.rc.turnOn();
		myClass.rc.setVolume(1);

		System.out.println("2.생성자");
		Myclass myClass2 = new Myclass(new Audio());
		myClass2.rc.turnOn();
		myClass2.rc.turnOff();
		
		System.out.println("3.메소드");
		Myclass myClass3 = new Myclass();
		myClass3.methodA();
		
		System.out.println("4.메소드");
		Myclass myClass4 = new Myclass();
		myClass4.methodB(new Televison());
	}

}
