package com.yedam.Reference;

public class Reference {

	public static void main(String[] args) {
		//참조 : 베열
		int[] array = {1,2,3,4,5,6};
		int[] array2 = {1,2,3,4,5,6};
		int[] array3 = null;
		
		System.out.println(array);
		System.out.println(array2);
		//배열 주소출력, 데이터가 동일하더라도 위치는 다름!
		
		System.out.println(array == array2); //거짓
		
		
	}

}
