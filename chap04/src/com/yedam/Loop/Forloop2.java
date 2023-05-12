package com.yedam.Loop;

public class Forloop2 {

	public static void main(String[] args) {
		//구구단 출력
		for(int k=2; k<=9; k++) {
		for(int i=1; i<=9; i++) {
			System.out.println(k+"*"+i+"="+(k*i));
		}
		}
		
		//별찍기
		for(int i = 1; i<=5; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
				System.out.println();
		}
		
		//별거꾸로찍기
		for(int i = 5; i>=0; i--) {
			for(int j=i; j >0; j--) {
			System.out.print("*");
			}
			System.out.println();
		}
		
	}
	

}
