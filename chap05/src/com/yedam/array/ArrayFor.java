package com.yedam.array;

public class ArrayFor {

	public static void main(String[] args) {
		//향상된 for문 : 가져올 항목 없으면 패스, 있다면 변수를 이용해 실행문 작동
		int newAry[] = new int[10];
		for(int temp : newAry) {
			System.out.println(temp + "\t");
		}

	}

}
