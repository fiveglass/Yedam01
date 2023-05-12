package test_0510;

import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		boolean run = true;
		int studentnum = 0;
		int[] stunum = null;
		int max = 0;
		int sum = 0;
		int avg = 0;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println("------------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("-------------------------------------------------");
			
			System.out.println("선택>");
			int menu=Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1 :
				System.out.println("학생수>");
				studentnum=Integer.parseInt(sc.nextLine());
				stunum = new int[studentnum];
				break;
			case 2 : 
				for(int i=0; i<stunum.length; i++) {
					System.out.println("scores[" + i + "]>");
					stunum[i]=Integer.parseInt(sc.nextLine());
				}
				break;
			case 3 :
				for(int i=0; i<stunum.length; i++) {
					System.out.println("scores[" + i + "]>" + stunum[i]);
				}
				break;
			case 4 : 
				for(int i=0; i<stunum.length; i++) {
					if(max<stunum[i]) {
						max=stunum[i];
					}
					sum = sum + stunum[i];
					avg = sum / stunum.length;
				}
				System.out.println("평균점수:" + avg);
				System.out.println("최고점수:" + max);
				break;
			case 5 :
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}

}
