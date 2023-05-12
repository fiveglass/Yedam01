package com.yedam.array;

public class Arrary5 {

	public static void main(String[] args) {
		//배열 복사
		int[] oldAry = {1,2,3};
		int[] newAry = new int[5];
		
		for(int i = 0; i<oldAry.length; i++) {
			newAry[i] = oldAry[i];
		}
		
		for(int i = 0; i<oldAry.length; i++) {
			System.out.println(newAry[i]);
		}
		
		//ArrayCopy 이용 시
		int[] oldAry2 = {1,2,3,4,5,6,7};
		int[] newAry2 = new int[10];
		//(원본배열, 시작인덱스, 새배열, 시작인덱스, 복사할 갯수)
		System.arraycopy(oldAry2, 1, newAry2, 3, oldAry2.length-1);
		
		for(int i = 0; i<oldAry2.length; i++) {
			System.out.println(newAry2[i]);
		}

	}

}
