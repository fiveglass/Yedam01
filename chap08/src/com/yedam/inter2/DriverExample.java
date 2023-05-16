package com.yedam.inter2;

public class DriverExample {

	public static void main(String[] args) {
		Driver driver = new Driver();
		
		driver.driver(new Bus());
		driver.driver(new Taxi());

	}

}
