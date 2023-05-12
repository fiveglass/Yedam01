package com.yedam.Loop;

import java.util.Scanner;

public class Forloop {

	public static void main(String[] args) {
		//for문
		for(int i = 0; i <= 100; i++) {
			System.out.println(i);
		}
		
		int result = 0;
		
		for(int i = 0; i <= 100; i++) {
			result = result +i;
		}
		
		System.out.println("1~100까지의 합은?" + result);
		
		
		//범위 내 짝수 혹은 홀수 구하기
		for(int i = 1; i<=100; i++) {
			if(i % 2 == 0) {
			 System.out.println("짝수");
			} else if (i % 2 == 1) {
				System.out.println("홀수");
			}
		}
		
		//입력한 숫자 구구단 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.println("구구단 입력");
		
		int gugu = Integer.parseInt(sc.nextLine());
		
		for(int i = 1; i <=9; i++) {
			System.out.println(gugu + "*" + i + "=" + (gugu*1));
		}
		
		//입력한 값에 대한 총합, 평균, 최대값, 최소값 구하기
		//몇번 반복 값을 입력 받는다
		//예시) 5번 -> 2, 50, 20, 10, 5
		
		
		System.out.println("첫번째 숫자 입력");
		int num1 = Integer.parseInt(sc.nextLine());
		
		System.out.println("두번째 숫자 입력");
		int num2 = Integer.parseInt(sc.nextLine());
		
		System.out.println("세번째 숫자 입력");
		int num3 = Integer.parseInt(sc.nextLine());
		
		System.out.println("네번째 숫자 입력");
		int num4 = Integer.parseInt(sc.nextLine());
		
		System.out.println("다섯번째 숫자 입력");
		int num5 = Integer.parseInt(sc.nextLine());
		
		
		int sum = num1 + num2 + num3 + num4 + num5;
		int avg = (num1 + num2 + num3 + num4 + num5)/5;
		//for(int numi=1; numi<=5; numi++) {
		//	int max = numi > numi;
		//}
		
		//int min = 
		
		System.out.println("총합: " + sum);
		System.out.println("평균: " + avg);
		//System.out.println("최대값: " + max);
		//System.out.println("최소값: " + min);
		
		//
		//1.변수활용
		
		boolean run = true;
		
		while(run) {
			System.out.println("1.덧셈 | 2. 뺄셈 | 3.곱셈 | 4.종료");
			System.out.println("입력>");
			
			int num = Integer.parseInt(sc.nextLine());
			
			switch(num) {
			case 1 : 
				System.out.println("더하고자 하는 두 수 입력");
				System.out.println("1>");
				int number1 = Integer.parseInt(sc.nextLine());
				System.out.println("2>");
				int number2 = Integer.parseInt(sc.nextLine());
				
				System.out.println(number1 + "+" + number2 + "=" + (number1+number2));
				break;
			case 2 : 
				
							
				break;
			case 3 : 
				
				break;
			case 4 : 
				System.out.println("프로그램 종료");
				run = false;
			}
		}
		
		//do while
		int month;
		
		do {
			System.out.println("올바른 월을 입력하시오[1-12]");
			month = sc.nextInt();
		} while (month <1 | month>12);
	}

}
