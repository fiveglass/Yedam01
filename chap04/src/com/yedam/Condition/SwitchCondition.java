package com.yedam.Condition;

import java.util.Scanner;

public class SwitchCondition {

	public static void main(String[] args) {
		int number = (int) (Math.random()*6)+1;
		
		switch (number) {
		case 1 :
			System.out.println("1");
			break;
		case 2 :
			System.out.println("2");
			break;
		case 3 :
			System.out.println("3");
			break;
		case 4 :
			System.out.println("4");
			break;
		case 5 :
			System.out.println("5");
			break;
		case 6 : //default : 가능
			System.out.println("6");
			break;
		}

		
		char grade = 'B';
		String grade2 = "b";
		
		switch(grade2) {
		case "A" :
			System.out.println("우수");
			break;
		case "B" :
		case "b" :
			System.out.println("일반");
			break;
		default : 
			System.out.println("손님");
			break;
		}
		
		
		//입력한 성적을 등급으로 표현
		Scanner sc = new Scanner(System.in);
		
		System.out.println("성적입력>");
		
		int score = Integer.parseInt(sc.nextLine());
		
		switch(score/10) {
		case 9 :
			if(score>=95) {
				System.out.println("A+");
			} else {
				System.out.println("A");
			}
			break;
		case 8 :
			if(score>=85) {
				System.out.println("B+");
			} else {
				System.out.println("B");
			}
			break;
		case 7 :
			if(score>=75) {
				System.out.println("C+");
			} else {
				System.out.println("C");
			}
			break;
		default : 
			System.out.println("D");
			break;
		}
		
		//메뉴선택
		System.out.println("1.글보기 2.글수정 3.글삭제 4.뒤로가기");
		int selectNo = Integer.parseInt(sc.nextLine());
		
		switch (selectNo) {
		case 1:
			System.out.println("글보는기능");
			break;
		case 2:
			System.out.println("글수정하는기능");
			break;
		case 3:
			System.out.println("글삭제하는기능");
			break;
		case 4:
			System.out.println("뒤로가는기능");
			break;
		}
	}

}
