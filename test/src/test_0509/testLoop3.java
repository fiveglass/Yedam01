package test_0509;

import java.util.Scanner;

public class testLoop3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("몇 번 입력하시겠습니까?");
		int count = Integer.parseInt(sc.nextLine());
		
		int total = 0;
		int min;
		int max;
		for(int i=0; i < count; i++) {
			System.out.println("데이터 입력>");
			int data = Integer.parseInt(sc.nextLine());
			total += data;
			
			min = data;
			max = data;
			if(min>data) {
				min=data;
			} else if (max<data) {
				max=data;
			}
		}
		
		int avg = total /count;
		

		System.out.println("총합: " + total);
		System.out.println("평균: " + avg);
		//System.out.println("총합: " + min);
		//System.out.println("총합: " + max);
	}

}
