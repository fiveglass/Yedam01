package com.yedam.inter2;

public class Bus implements vehicle{

	@Override
	public void run() {
		System.out.println("버스");
		
	}
	
	public void checkFare() {
		System.out.println("승차요금확인");
	}

}
