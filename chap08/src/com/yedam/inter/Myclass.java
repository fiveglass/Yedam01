package com.yedam.inter;

public class Myclass {
	//인터페이스 사용 가능 공간
	//1.필드
	RemoteControl rc = new Televison();
	
	public Myclass() {
		
	}
	
	public Myclass (RemoteControl rc) {
		this.rc = rc;
		rc.turnOn();
		rc.turnOff();
	}
	//->rc차이점
	//1.옆에 new Televison();대입
	
	
	public void methodA() {
		RemoteControl rc = new Audio();
		rc.turnOn();
		rc.turnOff();
	}
	
	public void methodB(RemoteControl rc) {
		
	}
} 
