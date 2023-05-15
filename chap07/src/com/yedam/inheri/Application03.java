package com.yedam.inheri;

public class Application03 {

	public static void main(String[] args) {
		int r = 10;
		
		Computer com = new Computer();
		System.out.println("원면적" + com.areaCircle(r));

		SupersonicAirplane sa = new SupersonicAirplane();
		 sa.fly();
		 sa.takeOff();
	}
	
//	 Child child = new Child();
//	 child.getInfo();
//	 child.method1();
//	 child.method2();
//	 child.method3();
	 
}
