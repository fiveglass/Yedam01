package com.yedam.exception;

public class ExceptionExample {
	public static void main(String[] args) {
		//nullpointException
		//String data = null;
		//System.out.println(data.length());
		
		//ArrayIndexOutOfBoundsException
		int[] intAry = new int[3];  //0~2
		
		intAry[0] = 1;
//		intAry[10] = 10;
		
//		for(int i = 0; i<=intAry.length; i++) {
//			System.out.println(intAry[i]);
//		}
		
		//NumberFormatException
		//바꿀 수 없는 숫자인데 바꾸려고 할 때
		String str = "123";
		int val = Integer.parseInt(str);
		System.out.println(val);
		
		//예외
//		String str2 = "자바";
//		val = Integer.parseInt(str2);
//		System.out.println(val);
		
//		String str3 = ""; //empty
//		val = Integer.parseInt(str3);
//		System.out.println(val);
		
		//ClassCastException
		//자동타입변환이 된 객체를 강제타입변환 발생
		
		//정상
		Example exam = new Exam();
		Exam exam02 = (Exam) exam;
		
		//예외
		Example exam03 = new Example();
//		Exam exam04 = (Exam) exam03;
		
		if(exam03 instanceof Exam) {
			Exam exam04 = (Exam)exam03;
		}
		
		//ClassNotFoundException -> Class 파일(Java)을 찾지 못할 때
		//실행메소드 -> main을 찾지 못할 때
		//Java파일을 찾아야하는데 못 찾는 경우
		
		//ArithmeticException -> 분모가 0일때
		// double a = 1/0;
		
		//IOException -> 입출력 오류
		//file reading / write
		
		//FileNotFoundException
		//java -> file reading -> 경로를 찾지 못해서 나는 오류
		
		//반복문 제대로 종료 하지 못하고 무한 루프 구성
		//OutofMemoryError -> 메모리 부족할때
		//memory leak (메모리 누수, 샌다, 부족)
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
