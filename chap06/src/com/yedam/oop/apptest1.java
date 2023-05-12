package com.yedam.oop;

public class apptest1 {

	public static void main(String[] args) {
		Book b1 = new Book("혼자공부하는자바", "수험서","24000", "0001", "한빛출판사");
		b1.getInfo();
		
		Book b2 = new Book("자바스크립트", "수험서", "15000", "0002", "어포스트");
		b2.getInfo();
	}

}
