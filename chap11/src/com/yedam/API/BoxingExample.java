package com.yedam.API;

public class BoxingExample {

	public static void main(String[] args) {
		//boxing 기본타입을 객체로 포장
		//권장은 아님
		Integer obj = new Integer(100);
		Integer obj1 = new Integer("100");
		
		Integer obj2 = Integer.valueOf(100);
		Integer obj3 = Integer.valueOf("100");
		
		int value1 = obj.intValue();
		int value2 = obj1.intValue();
		int value3 = obj2.intValue();
		int value4 = obj3.intValue();
		
		
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		System.out.println(value4);
		
		//자동박싱
		Integer obj5 = 100;
		System.out.println(obj5.intValue());
		
		//대입 시 자동 언박싱
		int value5 = obj5;
		System.out.println(value5);
		
		//연산 시 자동 언박싱
		int value6 = obj5+500;
		System.out.println(value6);
		
		//포장 값 비교 가능 값 존재 풀고 비교 필요
		Integer obj6 = 200;
		Integer obj7 = 200;
		
		System.out.println(obj.intValue() == obj7.intValue());
		
		double value7 = Double.parseDouble("3.14");
		System.out.println(value7);
	
	}

}
