package com.yedam.API;

import java.util.Date;
import java.util.Random;

public class SystemExample {
	public static void main(String[] args) {
		//System 클래스
		//강제 종료 : System.exit(0);
		
//		for(int i = 0; i<=10; i++) {
//			System.out.println(i);
//			if(i==5) {
//				System.exit(0);
//			}
//		}
//		System.out.println("프로그램 종료");
		
		//현재 시간 읽기
		//소요 시간( 끝나는 시간 - 시작 시간 = 소요시간)
		long time = System.nanoTime(); //시작 시간
		
		int sum = 0 ;
		
		for(int i = 0; i<= 1000000; i++) {
			sum += i;
		}
		
		long time2 = System.nanoTime();
		
		System.out.println(time);
		System.out.println(time2);
		System.out.println("1~1000000의 합 : " + sum);
		System.out.println("소요 시간 : " + (time2 -time) + "나노 초 소요");
		//중복되지 않은 데이터 구할 때
		System.out.println("현재 시간 : " + System.currentTimeMillis());
//		random(System.currentTimeMillis())
		
		Random r = new Random(System.currentTimeMillis());
		System.out.println(r.nextInt());
		
		
		
		
	}
}
