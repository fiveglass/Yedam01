package com.yedam.print;

public class PrintExample {

	public static void main(String[] args) {
		System.out.println("출력과 동시에 enter");
		
		System.out.print("출력");
		
		System.out.printf("이름 : %s, 나이 : %d, 온도 : %f", "김또치", 20, 9.5);
		
		System.out.println();
		
		int value = 123;
		System.out.printf("상품의 가격: %d원\n", value);
		System.out.printf("상품의 가격: %6d원\n", value);
		System.out.printf("상품의 가격: %-6d원\n", value);
		System.out.printf("상품의 가격: %06d원\n", value);
		
		System.out.printf(
				"반지름이 %d인 원의 넓이 %6.2f\n", 10, 3.14, 10*10);
		
		System.out.printf(
				"%6d | % -10s | %10s\n", 1, "홍길동", "도적");
					
	}

}
