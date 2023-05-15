package com.yedam.inheri;

public class SmartPhone extends CellPhone{ 
	String agency;
	
	SmartPhone(String model, String color, String agency){
		this.model = model;
		this.color = color;
		this.agency = agency;
	}
	
	
	
	void kakaoExe() {
		System.out.println("카카오톡 실행");
	}
	void Info() {
		System.out.println("통신사:"+agency+"입니다.");
	}
	void kakaoExit() {
		System.out.println("카카오톡 종료");
	}
}
