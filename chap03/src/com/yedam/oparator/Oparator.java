package com.yedam.oparator;

public class Oparator {

	public static void main(String[] args) {
		//++num, num++
		int num = 0;
		System.out.println(num++);
		System.out.println(++num);
		System.out.println(num--);
		System.out.println(--num);
		
		//논리부정연산자 : !(not)
		boolean play =true;
		System.out.println();
		
		//비교연산자 
		int num1 = 10;
		int num2 = 10;
		
		boolean result1 = (num1 == num2);
		boolean result2 = (num != num2);
		boolean result3 = (num1 <= num2);
		
		
		char char1 = 'A';
		char char2 = 'B';
		
		boolean result4 = (char1<char2);
		System.out.println(result4);
		
		//논리연산자
		
		char charCode ='A';
		if(charCode >= 65 && charCode <= 90) {
			System.out.println("대문자");
		}
		
		
		//논리부정연산자
		if(!(charCode<65) && !(charCode>90) ) {
			System.out.println("대문자");
			
			//반복 대입 연산자
			int result = 0;
			result += 10;
			
			//삼항 연산자
			int score= 8;
			
			/*if(score >=80) {
				grade = 'B';
			}else {
				grade
			}*/
		}
	}

}
