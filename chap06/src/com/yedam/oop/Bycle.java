package com.yedam.oop;

public class Bycle {
	//필드
	int gas;
	
	//생성자

	//메소드	
	void setGas(int gas) {
		this.gas = gas;
	}
	
	boolean isLeftGas() {
		if(gas == 0) {
			System.out.println("gas 없음");
			return false;
		} 
		System.out.println("gas 있음");
		return true;
		}
	void run() {
		while(true) {
			if(gas>0) {
				System.out.println("달립니다 잔량 :" + gas);
				gas-=1;
			}else {
				System.out.println("멈춥니다 전량 :" + gas);
				return;
			}
		}
	}

}
