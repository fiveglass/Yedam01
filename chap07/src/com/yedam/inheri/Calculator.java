package com.yedam.inheri;

public class Calculator {
	//부모클래스 ->원넓이 구하는 메소드
	double areaCircle(double r) {
		System.out.println("Calculator 부모 객체 메소드 실행");
		return 3.14 * r * r;
	}
}
