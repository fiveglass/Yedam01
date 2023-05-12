package test_0509;

import java.util.Scanner;

public class testWhile {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//오락실 만들기
		//오락 한 번 : 500원
		
		System.out.println("===========insert cion==========");
		int money = Integer.parseInt(sc.nextLine());
		
		while(money > 500) {
			System.out.println((money/500) + "번 기회 남았습니다!");
			System.out.println("1.가위바위보 | 2. UP&DOWN | 3.종료");
			
			System.out.println("메뉴입력>");
			int gameNo = Integer.parseInt(sc.nextLine());
			
			switch(gameNo) {
			case 1 :
				System.out.println("가위바위보 진행");
				money = money-500;
				break;
			case 2 :
				System.out.println("up&down 진행");
				money = money-500;
				break;
			case 3 :
				System.out.println("프로그램 종료");
				
				break;
			}
		}

	}

}
