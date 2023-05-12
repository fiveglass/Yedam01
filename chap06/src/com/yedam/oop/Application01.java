package com.yedam.oop;

public class Application01 {
	//실행클래스
	public static void main(String[] args) {
		//car class -> 객체
		//타입 변수 객체생성 생성자 : 생성자호출
		Car myCar = new Car();
		
		//dot 를 사용
		System.out.println(myCar.company);
		System.out.println(myCar.price);
		System.out.println(myCar.name);
		
		//데이터입력방식 1. 클래스 외부에서 객체 생성 후 필드 호출
		myCar.company = "현대";
		myCar.price = 1234;
		myCar.name = "소나타";
		
		System.out.println("객체 필드 데이터");
		System.out.println(myCar.price);
		System.out.println(myCar.name);
		System.out.println(myCar.company);
		System.out.println(myCar.price);
		System.out.println(myCar.name);	
		
		Car yourCar = new Car();
		System.out.println("myCar와 yourCar");
		System.out.println(myCar.price);
		System.out.println(yourCar.company);	
		
		System.out.println("Korean class");
		
		Korean k1 = new Korean("박자바", "01125-3211321");
		System.out.println(k1.nation);
		System.out.println(k1.name);
		System.out.println(k1.ssn);
		
		System.out.println("생성자 오버로딩");
		//매개변수가 하나인 생성자 활용
		Car oneCar = new Car("소나타");
		System.out.println("oneCar : " + oneCar.name);
		oneCar.run();
		System.out.println(oneCar.info());
		
		Car threeCar = new Car("그랜저" , 3000 , "현대");
		System.out.println("threecar name" + threeCar.name);
		System.out.println("threecar price" + threeCar.price);
		System.out.println("threecar company" + threeCar.company);
		}

}
