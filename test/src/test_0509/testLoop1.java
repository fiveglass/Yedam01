package test_0509;

import java.util.Scanner;

public class testLoop1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 숫자 입력");
		int num1 = Integer.parseInt(sc.nextLine());
		
		System.out.println("두번째 숫자 입력");
		int num2 = Integer.parseInt(sc.nextLine());
		
		System.out.println("세번째 숫자 입력");
		int num3 = Integer.parseInt(sc.nextLine());
		
		System.out.println("네번째 숫자 입력");
		int num4 = Integer.parseInt(sc.nextLine());
		
		System.out.println("다섯번째 숫자 입력");
		int num5 = Integer.parseInt(sc.nextLine());
		
		
		int sum = num1 + num2 + num3 + num4 + num5;
		int avg = (num1 + num2 + num3 + num4 + num5)/5;
		int max = num1;
		for(int numi=1; numi<=5; numi++) {
			if(max < numi) {
				max = numi;
			}
		}
		int min = num1;
		for(int numi=1; numi<=5; numi++) {
			if(min > numi) {
				min = numi;
			}
		}

		
		System.out.println("총합: " + sum);
		System.out.println("평균: " + avg);
		System.out.println("최대값: " + max);
		System.out.println("최소값: " + min);
		
		//
		
		
		
		//선생님
		int count = Integer.parseInt(sc.nextLine());
		int total = 0;
		
		for(int i=0; i < count; i++) {
			System.out.println("데이터 입력>");
			int data = Integer.parseInt(sc.nextLine());
			//총합계
			total += data;
			//최대값
			if(i==0) {
				max = data;
				min = data;
			}else {
				if(max < data) {
					max = data;
				}
				
				if(min >data) {
					min = data;
			}
			}
			//평균
			//System.out.println("평균 : %5.2f\n", (double)total/count);
			
			//임의의 랜덤 값(1~100) 하나 추출
			//5번 기회 안에 해당 랜덤값을 맞추는 프로그램 구현
			//조건1. 맞춘경우 : 정답 입니다, 몇 번만에 맞추셨습니다.
			//조건2. 못맞춘경우 : 모든 기회를 소진 하셨습니다.
			
			int randomNo = (int) (Math.random()*100)+1;
			
			
			for(i=1; i<=5; i++) {
				System.out.println("번호를 맞춰보세요.");
				int chance = Integer.parseInt(sc.nextLine());
				if(randomNo==chance) {
					System.out.println("정답입니다."+ i + "번째 맞추셨습니다.");
					break;
				} else if (randomNo < chance) {
					System.out.println("up");
				} else if (randomNo > chance) {
					System.out.println("down");
				} 
			}

			System.out.println("Game Over");
			
		}

	}

}
