package com.yedam.oop;

public class Computer {
	//필드
		
		
	//생성자
	
	//메소드
	//1)배열활용 : 매개 변수의 값을 모를 경우
	int sum1(int[] values) {
		int sum = 0;
		for(int i = 0; i<values.length; i++) {
			sum += values[i];
		}
		return sum;
	}
	
	//2)목록 넘겨주는 형식
	//+ ... 메소드 호출 시 넘겨준 값의 수에 따라 자동으로 배열 생성
	int sum2(int ... values) {
		int sum = 0;
		for(int i = 0; i<values.length; i++) {
			sum += values[i];
		}
		return sum;
	}
}
