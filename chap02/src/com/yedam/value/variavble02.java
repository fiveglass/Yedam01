package com.yedam.value;

public class variavble02 {
	public static void main(String[] args) {
		//정수타입 : int
		//이진수 표현
		int var1 = 0b1011;
		int var2 = 0206;
		int var3 = 365;
		int var4=0xB3;
		
		System.out.println("var1:"+var1);
		System.out.println("var2:"+var2);
		System.out.println("var3:"+var3);
		System.out.println("var4:"+var4);
		
		//정수타입의 범위
		byte Var11 = 20;
		
		//정수타입 : long
		//int 범위 : - 2, 147, 483, 648  ~ 2, 147, 483, 648
		long Var21 = 2000000000L;
		
		//정수타입 : char
		char c1 = 'A';
		char c2 = 65;
		char c3 ='\u0041';
		
		char c4 = '가';
		char c5 =44032;
		char c6 ='\uac00';
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
		
		//String타입 : 문자열 
		String name="홍길동";
		String job="프로그래머";
		
		//이스케이프 문자
		// \t : tab만큼 띄어쓰기
		// \n : enter
		// \\ : 특수한 문자 사용(\)
		//  \": 특수한 문자 사용(")
		
		System.out.println(name + "\n" + job);
		System.out.println("행 단위 출력");
		System.out.println("우리는 \"개발자\"입니다");
		System.out.println("봄\\여름\\가을\\겨울");
		
		
		//실수 타입 : float, double
		//float은 값에 f를 붙여주어야 실수로 인식
		float fVar1 = 3.14f;
		double dVar1 = 3.14;
		
		
		//float은 8자리 이상 실수는 생략
		float fVar2 = 0.123456781234f;
		double dVar2 = 0.1234567891234;
		
		System.out.println(fVar2);
		System.out.println(dVar2);
		
		float fVar3=3e-3f;
		double dVar3=3e6;
		
		System.out.println(fVar3);
		System.out.println(dVar3);
		
		//논리타입 : boolean
		boolean stop= true;
		if(stop) {
			System.out.println("멈춥니다");
		} else {
			System.out.println("달립니다");
		}
		
		
		
		}
}
