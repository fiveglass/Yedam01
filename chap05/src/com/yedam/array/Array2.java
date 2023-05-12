package com.yedam.array;

import java.util.Scanner;

public class Array2 {

	public static void main(String[] args) {
		int[] intAry = new int[10];
		
		System.out.println("길이 " + intAry.length);
		
		for(int i=1; i<10; i++) {
			System.out.println(intAry[i]);
		}
		
		for(int i=1; i<intAry.length; i++) {
			System.out.println(intAry[i]);
		}

		//배열
		int[] ary;
		
		//배열의 크기
		int no;
		
		Scanner sc = new Scanner(System.in);
		no = Integer.parseInt(sc.nextLine());
		
		ary = new int[no];
		
		System.out.println(ary.length);
		
		//데이터 입력
		for(int i=1; i<ary.length; i++) {
			System.out.println("입력>");
			int data = Integer.parseInt(sc.nextLine());
			ary[i] = data;
		}
		//데이터 확인
		for(int i=1; i<ary.length; i++) {
			System.out.println(ary[i]);
		}
		
		//국영수의 데이터를 담는 배열
		//가정1.[0]국어, [1]영어, [2]수학
		int[] point = new int[3];
		
		System.out.println("국어점수>");
		point[0] =Integer.parseInt(sc.nextLine());
		System.out.println("영어점수>");
		point[1] =Integer.parseInt(sc.nextLine());
		System.out.println("수학점수>");
		point[2] =Integer.parseInt(sc.nextLine());
		
		//1)점수의 총합계
		int sum = 0;
		for(int i=0; i<point.length; i++) {
			sum = sum + point[i];
		}
		
		System.out.println("합계:" + sum);
		
		//2)평균값
		double avg = (double)sum/point.length;
		
		System.out.println("평균:" + avg);
		
		//입력받은 데이터의 갯수의 총합, 평균, 최대, 최소
		//빈배열생성
		int[] intAry2;
		
		//데이터 배열길이 받고 생성
		System.out.println("데이터갯수?");
		int num=Integer.parseInt(sc.nextLine());
		intAry2 = new int[num];
		
		//배열길이 만큼 데이터 입력하기
		for(int i=0; i<intAry2.length; i++) {
			System.out.println((i+1)+"번째 입력");
			intAry2[i]=Integer.parseInt(sc.nextLine());
		}
		
		//변수선언해두기
		sum=0;
		avg=0;
		int max=intAry2[0];
		int min=intAry2[0];
		
		//총합
		for(int i=0; i<point.length; i++) {
			System.out.println(intAry2);
			sum += intAry2[i];
			//최대값
			if(max<intAry2[i]) {
				max = intAry2[i];
			}
			//최소값
			if(min>intAry2[i]) {
				min = intAry2[i];
		}
		
		}
		
		System.out.println("합계 : " + sum);
		System.out.println("최대값 : " + max + "," + "최소값 : " + min);
		System.out.println("평균 : "+ (double)sum/intAry2.length);

		
		
	}

}
