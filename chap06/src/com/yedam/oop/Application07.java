package com.yedam.oop;

public class Application07 {
	Application07 app = new Application07();
	
	int a = app.num + 1;
	
	//필드선언
		static int num = 1;
		
	//->정적멤버 : 객체 생성 없이 바로 사용할 수 있는 필드나 메소드
	//메소드선언
		static void info() {
			System.out.println("info 출력");
		}
	
		public static void main(String[] args) {
			info();
		//->이렇게 선언하기 위해서는 해당 메서드에 static(정적) 선언 해주기
	
	//클래스에 정의된 정적 멤버 사용
	//클래스명.필드명 |클래스명.메소드명
		System.out.println(StaticCal.minus(10, 5));
		System.out.println(StaticCal.plus(10, 5));
		
	
		Person p1 = new Person("11111-11111", "깃허브");
		System.out.println(p1.nation);
		System.out.println(p1.ssn);
		System.out.println(p1.name);
		
		System.out.println("지구반지름"+StaticCal.EARTH_ROUND);
		
		
	}
	
	
}
