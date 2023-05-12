package com.yedam.oop;

import java.util.Scanner;

public class application05 {

	public static void main(String[] args) {
		String[] strAry = new String[3];
		strAry[0] = "첫번째";
		
		//객체배열
		//Book Class
		
		Book[] bookAry = new Book[10];
		
		//객체를 생성해서 저장
		Book b1 = new Book("혼자공부하는자바", "수험서", "24000", "0001", "한빛출판사");
		bookAry[0] =b1;
		System.out.println(b1);
		System.out.println(bookAry[0]);
		//b1.getInfo();
		//bookAry[0].getInfo()
		
		//배열의 공간에 바로 객체 생성
		bookAry[1] = new Book("자바스크립트", "수험서", "15000", "0002", "어포스트");
		
		//객체 배열
		//책들의 정보를 저장하는 프로그램
		//1. 책 권 수
		//2. 책 정보 입력
		//3. 책 정보 확인
		//4. 종료
		
		//책 정보 보관 배열
		Book[] bookAry2 = null;
		
		//책 권 수 
		int bookNum = 0;
		
		//데이터 입력
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("------------------------------------------------");
			System.out.println("1.책 권 수 | 2.책 입력 | 3.정보확인 | 4.종료");
			System.out.println("-------------------------------------------------");
			
			String selectNo = sc.nextLine();
			
			if(selectNo.equals("1")) {
				//데이터 입력->배열->크기
				System.out.println("책 권 수?");
				bookNum=Integer.parseInt(sc.nextLine());
			}else if (selectNo.equals("2")) {
				//받은 책 권 수 만큼 길이 배열 생성
				bookAry2=new Book[bookNum];
				//배열 만큼 책 입력 기능
				for(int i=0; i<bookAry2.length; i++) {
					//객체 생성
					Book book = new Book();
					
					//책 입력
					System.out.println("책 제목>");
					book.bookname = sc.nextLine();
					System.out.println("책 종류>");
					book.booktype = sc.nextLine();
					System.out.println("책 가격>");
					book.price = sc.nextLine();
					System.out.println("도서번호>");
					book.bookno = sc.nextLine();
					System.out.println("출판사>");
					book.company = sc.nextLine();
					
					//책 정보 배열에 저장
					bookAry2 [i] = book;
				}
			}else if (selectNo.equals("3")) {
				//모든 책 정보 확인
				for(int i=0; i<bookAry2.length; i++) {
					System.out.println((i+1)+"번째 책 정보");
					bookAry2[i].getInfo();
					System.out.println();
				}
			}else if (selectNo.equals("4")) {
				System.out.println("프로그램 종료");
				break;
			} else {
				System.out.println("없는 번호");
			}
			
		}
	}

}
