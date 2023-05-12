package com.yedam.array;

public class Array4 {

	public static void main(String[] args) {
		//배열을 다룰 때 자주 나는 오류 : IndexOutOfBoundsException
				//->배열의 범위를 벗어나는 인덱스 사용
				
				String[] strAry = new String[3];
				strAry[0] = "yedam";
				strAry[1] = "yedam";
				strAry[2] = new String("yedam");
				
				//String 배열 간의 주소값 비교
				System.out.println(strAry[0] == strAry[1]);
				System.out.println(strAry[0] == strAry[2]);
				
				//String 배열 간 데이터 비교
				System.out.println(strAry[0].equals(strAry[2]));

	}

}
