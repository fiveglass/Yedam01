package com.yedam.oop;

public class Application02 {

	public static void main(String[] args) {
		Bycle bycle = new Bycle();
		
		bycle.setGas(5);
		
		boolean gasState = bycle.isLeftGas();
		if(gasState) {
			System.out.println("출발");
			bycle.run();
		}
		
		if(bycle.isLeftGas()) {
			System.out.println("gas 주입 필요");
		} else {
			System.out.println("멈첩니다.gas잔량 : " + bycle.gas);
			return;
		}

	}

}
