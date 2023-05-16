package com.yedam.inter2;

public class Car {
	//car클래스에 tire넣기
	Tire flt = new KumhoTire();
	Tire frt = new KumhoTire();
	Tire blt = new KumhoTire();
	Tire brt = new KumhoTire();
	
	void run() {
		flt.roll();
		frt.roll();
		blt.roll();
		brt.roll();
	}
}
