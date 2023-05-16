package com.yedam.inter2;

public class Driver {
	public void driver(vehicle vehicle) {
		if(vehicle instanceof Bus) {
		Bus bus = (Bus) vehicle;
		bus.checkFare();
		}
		vehicle.run();
	}
}
