package com.yedam.array;

import java.util.Arrays;

public class Array3 {

	public static void main(String[] args) {
		// intAry[0] -> 1, 2
		// intAry[1] -> 1, 2, 3
		
		int[][] mathScore = new int[2][3];
		
		for(int i = 0; i<mathScore.length; i++) {
			System.out.println("mathScore length :" + mathScore.length);
			for(int j=0; j<mathScore[i].length; j++) {
				System.out.println("mathScore" + i + "," + j +"= mathScore");
			}
			System.out.println();
		}
		//이차원 배열 -> 구구단 저장
		//2...9단 =>8개
		//1...9 =>9개
		
		int[][] gugu = new int [8][9];
		
		for(int i =2; i<10; i++) {
			for(int j = 1; j<10; j++) {
				gugu[i-2][j-1] = i*j;
			}
		}
		
		for(int i = 0; i<gugu.length; i++) {
			System.out.println((i+2)+ "단");
			System.out.println(Arrays.toString(gugu[i]));
		}
		
	
	}

}
