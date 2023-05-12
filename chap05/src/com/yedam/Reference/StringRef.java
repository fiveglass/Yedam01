package com.yedam.Reference;

public class StringRef {

	public static void main(String[] args) {
		
		String strVal1 = "yedam";
		String strVal2 = "yedam";
		
		if(strVal1 == strVal2) {
			System.out.println("메모리주소 동일");
		} else {
			System.out.println("메모리주소 상이");
		}

		if(strVal1.equals(strVal2)) {
			System.out.println("데이터 동일");
		} else {
			System.out.println("데이터 상이");
		}
		
		//new 연산자 활용을 통한 새로운 String 객체 생성
		//heap 객체 생성 -> heap에 문자열 넣을 수 있는 공간 생성
		
		String strVal3 = new String("yedam");
		String strVal4 = new String("yedam");
		
		if(strVal3 == strVal4) {
			System.out.println("메모리주소 동일");
		} else {
			System.out.println("메모리주소 상이");
		}
		
		//객체 간 데이터 비교
		if(strVal3.equals(strVal4)) {
			System.out.println("데이터 동일");
		} else {
			System.out.println("데이터 상이");
		}
				
	}
}
