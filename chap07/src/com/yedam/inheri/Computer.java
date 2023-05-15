package com.yedam.inheri;

public class Computer extends Calculator{
	
	@Override //어노테이션
	//오버라이딩은? 마음에 들지 않는 부분을 수정
	double areaCircle(double r) {
		System.out.println("Computer 객체의 메소드 실행");
		return Math.PI * r * r;
	}
}
