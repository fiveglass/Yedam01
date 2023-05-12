package com.yedam.array;

public class Array1 {

	public static void main(String[] args) {
		//값 목록을 활용해서 배엷만들기
		//총 6개 데이터를 담을 수 있는 배열
		//각 데이터를 배열의 공간에 입력
		//배열 생성과 동시에 데이터 입력
		int[] intAry = {1,2,3,4,5,6};
		int[] intAry2 = new int[6];
		
		intAry[0]=1;
		intAry[1]=2;
		intAry[2]=3;
		intAry[3]=4;
		intAry[4]=5;
		intAry[5]=6;
		
		//문자열을 입력할 수 있는 배열 생성
		String[] strAry = new String[10];
		System.out.println(intAry2[0]);
		System.out.println(strAry[9]);
		
		System.out.println(intAry[2]);
		int sum = 0;
		
		//반복문과 배열
		int[] score = {83,90, 87};
		
		for(int i = 0; i<3; i++) {
			System.out.println(score);
			sum += score[i];
		}
		
		System.out.println(sum);
		
		//new 연산자를 활용한 배열 생성
		int[] point;
		point = new int[] {1,2,3};
		
		//데이터 입력 없음
		int[]arr1 = new int[3];	
		
		for(int i=0; i<3; i++) {
			System.out.println("arr" + i + arr1[i]);
		}
		
		
		//
		int[]arr2=new int[3];
		arr2[0]=10;
		arr2[1]=20;
		arr2[2]=30;		
		
		for(int i=0; i<3; i++) {
			System.out.println("arr2"+i+arr2[i]);
		}
		
		//참조객체 String 활용법
		String[]arr3=new String[3];
		arr3[0]="3월";
		arr3[1]="10월";
		arr3[2]="11월";
		
		for(int i=0; i<3; i++) {
			System.out.println("arr3"+i+arr2[i]);
		}
		
	}

}
