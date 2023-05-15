package com.yedam.abs;

public class SmartPhone extends Phone{

	public SmartPhone(String owner) {
		super(owner);
	}

	@Override
	public void turnOff() {
		System.out.println("반드시 구현한 TurnOff 메 소 드");
	}
	
	public void internetSearch() {
		System.out.println("인터넷을 검색합니다.");
	}
	
}
