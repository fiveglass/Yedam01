package com.yedam.oop;

public class Book {
	//book 클래스 정보 : 책이름, 책종류, 가격, 도서번호, 출판사
	String bookname;
	String booktype;
	String price;
	String bookno;
	String company;
	
	//생성자 2개
	//기본 생성자
	Book(){}
	
	//모든 데이터를 받아오는 생성자
	Book(String bookname, String booktype, String price, String bookno, String company){
		this.bookname = bookname;
		this.booktype = booktype;
		this.price = price;
		this.bookno = bookno;
		this.company = company;
	}
	
	//메소드
	//모든 정보를 출력할 수 있는 getInfo()
	void getInfo() {
		System.out.println(
				"책이름 : " + bookname + "\n" +
				"#내용" + "\n" +
				"1) 종류 : " + booktype + "\n" +
				"2) 가격 : " + price + "\n" +
				"3) 출판사 : " + company + "\n" +
				"4) 도서번호 : " + bookno
				);
		
	}
	
	//객체 생성 할 때, 생성자를 통한 필드 초기화
	//다음과 같은 출력 결과가 나오도록 구현
	//객체.getInfo()
	//책이름 : 혼자 공부하는 자바
	//#내용
	//1) 종류 : 학습서
	//2) 가격 : 24000원
	//3) 출판사 : 한빛미디어
	//4) 도서번호 : 0001
	
	//책이름 : 자바스크립트
	//#내용
	//1) 종류 : 학습서
	//2) 가격 : 15000원
	//3) 출판사 : 어포스트
	//4) 도서번호 : 0002
	
}
