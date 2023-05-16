package com.yedam.exception;

public class Application01 {
	public static void main(String[] args) {
//		try {
//			//예외가 발생할만한 코드
//		}catch(예외 종류(nullpoint, numberformat,,,)) {
//			//예외, 문제가 발생했을 때 처리하는 코드
//		}finally {
//			//try 또는 catch문 실행하고 나서 무조건!
//			//실행하는 코드
//			//필수는 아니고 선택
//		}

		try {
			double avg = 1 / 1;
			System.out.println(avg);

			String str = "123";
			int a = Integer.parseInt(str);
			//ClassNotFound
			Class clazz = Class.forName("java.lang.String"); 
					
		} catch (ArithmeticException e) {
			System.out.println("숫자를 0으로 나눠서 예외 발생");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("문자열 -> 정수로 변환 실패");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println("finally 항상 실행");
		}
		
//		try {
//			findClass();	
//		}catch(ClassNotFoundException e) {
//			System.out.println("클래스가 존재하지 않습니다.");
//		}
		try {
			findClass();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void findClass() throws ClassNotFoundException {
		Class clazz = Class.forName("java.lng.String2");
	}
	
	
	
	
	
}
