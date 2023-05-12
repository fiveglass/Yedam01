package com.yedam.Condition;

import java.util.Scanner;

public class IfCondition {

	public static void main(String[] args) {
		int score = 93;
		
		if(score >= 90) {
			System.out.println("점수가 90이상이고 A등급");
		}
		
		if(score > 90) {
			System.out.println("A등급");
		}
		
		if(score >=90) {
			System.out.println("점수 90이상");
		} else {
			System.out.println("점수가 애게게");
		}
		
		if(score >= 90) {
			System.out.println("A등급");
		}else if(score >= 80) {
			System.out.println("B등급");
		}else if(score >= 70) {
			System.out.println("C등급");
		}else {
			System.out.println("D등급");
		}
		
		//random() 랜덤값추출
		//Math.random() : 실수로 값이 나옴 
		//(타입)Math.random()*원하는 범위+1
		//-> 추출 범위 선택 : 양쪽에 *범위 만큼 하는 원리 , ex) (int)math.random()*10+1
		//-> 정수값 타입 변환 : 강제 타입 변환 원리,  ex) (int)math.random()*10+1
		
		//주사위 번호 뽑기
		int number = (int)(Math.random()*6) + 1;
		if(number == 1) {
			System.out.println("1");
		} else if (number == 2) {
			System.out.println("2");
		} else if(number == 3) {
			System.out.println("3");
		} else if(number == 4) {
			System.out.println("4");
		} else if(number == 5) {
			System.out.println("5");
		} else {
			System.out.println("6");
		}
		
		//중첩if문 : 하나의 데이터를 여러번 조건 확인 할 때
		int no = 10;
		if(no%2 ==0) {
			if(no%10==0) {
				System.out.println("2의배수, 5의배수, 10의배수");
			}
		}
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("점수입력>");
		
		score = Integer.parseInt(sc.nextLine());
		
		String grade ="";
		
		if(score >= 90) {
			
		}
		
		
		
	}

}
