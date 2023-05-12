package com.yedam.oop;

public class Car {

		//필드 : 객체를 만들었을 때 정보를 담아주는 역할
		//필드선언
		String name; //자동차이름
		int price; //가격
		String company = "벤틀리"; //브랜드, 제조사

		//생성자 : Car(매개변수, 매개변수...){} 객체를 만들 때 내가 하고 싶은 행위 정의
		//생성자 호출 : Car 변수명 = new Car(매개변수, 매개변수...); -> 매개변수로 생성자 데이터 입력
		//조건1. 생성자 이름은 클래스이름과 같아야함
		//조건2. 생성자 생략 시 바이트코드 파일에 기본생성자가 자동 생성
		Car(){}
		
		//생성자 오버로딩
		Car(int price, String name){
			
		}
		Car(String name, int price){
			
		}
		Car(String name){
			this(name, 10000, "현대");
			System.out.println("자동차 이름만 입력");
		}
		Car(int price){
			
		}
		Car(String name, int price, String company){
			this.name = name;
			this.price = price;
			this.company = company;
			System.out.println("모든 필드 초기화");
		}
		//메소드 : 객체가 사용할 수 있는 기능
		//반환값이 없는 메소드
		void run() {
			System.out.println("자동차가 달립니다.");
		}
		
		//문자열 반환 메소드
		String info() {
			String data = company + ":" + name + "." + 100000;
			return data;
		}

}
