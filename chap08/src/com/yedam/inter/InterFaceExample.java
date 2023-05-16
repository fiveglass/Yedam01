package com.yedam.inter;

public class InterFaceExample {

	public static void main(String[] args) {
//		RemoteControl rc = new Televison();
//		rc.turnOn();
//		rc.turnOff();
//		rc.setVolume(5);
//		rc.setVolume(12);
//		rc.setVolume(-50);
//		rc.turnOff();
//		
//		rc.search("www.google.com");
//		System.out.println();
//		rc = new Audio();
//		rc.turnOn();
//		rc.setVolume(3);
//		rc.setVolume(-1);
//		rc.turnOff();
//		
//		Searchable rc2 = new Televison();
//		rc2.search("www.naver.com");
		
		InterfaceC ic = new ImplementsC();
		ic.method1();
		ic.method2();
		ic.method3();
	}

}
