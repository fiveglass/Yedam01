package hw;

import java.util.Scanner;

public class 오유리_0510 {

	public static void main(String[] args) {
		//주어진 배열을 이용하여 다음 내용을 구현하세요.
		int[] arr1 = { 10, 20, 30, 50, 3, 60, -3 };
		
		//문제1. 주어진 배열 중에서 값이 60인 곳의 인덱스를 출력해보자.
		for(int i=0; i<arr1.length; i++) {
			if(arr1[i] == 60){
				System.out.println("arr["+i+"]이 60입니다.");
			}
		}
		
		//문제2. 주어진 배열의 인덱스가 3인 곳은 출력하지 말고, 나머지만 출력해보자.
		for(int i=0; i<arr1.length; i++) {
			if(arr1[i] == arr1[3]){
				arr1[i]=0;
			} else {
				System.out.println(arr1[i]);	
			}
		}
		
		
		//문제3. 주어진 배열 안의 변경하고 싶은 값의 인덱스 번호를 입력받아, 그 값을 1000으로 변경해보자.
  		//   입력) 인덱스: 3 ->   {10, 20, 30, 1000, 3, 60, -3}
		Scanner sc = new Scanner(System.in);
		System.out.println("변경하고 싶은 인덱스 번호는?");
		int change = Integer.parseInt(sc.nextLine());
		
		for(int i=0; i<arr1.length; i++) {
			if(arr1[i] == arr1[change]){
				arr1[i] = 1000;
			}
				System.out.println(arr1[i]);
		}
		
		//문제4. 별도의 배열을 선언하여 양의 정수 10개를 입력받아 배열에 저장하고, 배열에 있는 정수 중에서 3의 배수만 출력해보자.
		int newary[] = new int[10];
		
		for(int i=0; i<newary.length; i++) {
			System.out.println("입력>");
			int num = Integer.parseInt(sc.nextLine());
			newary[i] = num;
		}
			
		for(int num : newary) {
			if(num % 3 == 0) {
				System.out.println(num);
			}
		}
		

		//추가문제
		//X대학 M교수님은 프로그래밍 수업을 맡고 있다. 교실엔 학생이 30명이 있는데, 학생 명부엔 각 학생별로 1번부터 30번까지 출석번호가 붙어 있다.
		//교수님이 내준 특별과제를 28명이 제출했는데, 그 중에서 제출 안 한 학생 2명의 출석번호를 구하는 프로그램을 작성하시오.
		//참고 : 백준 https://www.acmicpc.net/problem/5597
		
		
	}

}
