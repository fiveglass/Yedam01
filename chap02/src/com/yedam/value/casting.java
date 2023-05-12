package com.yedam.value;

public class casting {

	public static void main(String[] args) {
		//자동타입변환
		byte bValue = 10;
		int iValue = bValue;
		
		System.out.println("iValue :" + iValue);
		
		char charVal = '가';
		iValue = charVal;
		
		System.out.println("가의 유니코드 : " + iValue);
		
		iValue=50;
		long lValue = iValue;
		System.out.println("lvalue : " + lValue);
		
		double dValue = lValue;
		System.out.println("dValue" + lValue);
		
		//강제타입변환
		int iVar = 127;
		byte bVar = (byte)iVar;
		
		int iVar2 = 44032;
		char charVar = (char)iVar2;
		System.out.println("charVar");
		
		//실수-정수 강제 타입 변환
		//자동 타입 변환 경우 : int(3)->double(3.0)
		//강제 타입 변환 경우(3.5) : 소수점 아래 내용을 제외 후 정수로 변환하기
		
		double dVar=4.14;
		iVar2= (int)dVar;
		
		System.out.println(iVar2);
	}

}
