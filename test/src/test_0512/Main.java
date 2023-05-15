package test_0512;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		boolean play = true;
		int size = 0;
		int num;
		int count = 0;
		int one= 0;
		int two= 0;
		int three= 0;
		int four= 0;
		int five =0;
		int six =0;
		int seven =0;
		int eig = 0;
		int nine =0;
		int ten = 0;
		
		
		while(run) {
			System.out.println("===1.주사위 크기 2.주사위 굴리기 3.결과 보기 4.가장 많이 나온 수 5.종료 ===");
			
			System.out.println("메뉴>");
			int menu=Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1 : 
				System.out.println("주사위 크기>");
				size=Integer.parseInt(sc.nextLine());
				
				if(size<5){
					System.out.println("5~10까지 입력해주세요.");
					size=Integer.parseInt(sc.nextLine());
				} else if(size>10) {
					System.out.println("5~10까지 입력해주세요.");
					size=Integer.parseInt(sc.nextLine());
				}
				break;
			case 2 :
				while(play) {
					num = (int)(Math.random() * size )+1;
					count = num++;
					if(num == 5) {
						System.out.println("5가 나올 때까지" + count + " 번 굴렀습니다.");
						play=false;
					} else if (num == 1) {
						one++;
					} else if (num == 2) {
						two++;
					} else if (num == 3) {
						three++;
					} else if (num == 4) {
						four++;
					} else if (num == 5) {
						five++;
					} else if (num == 6) {
						six++;
					} else if (num == 7) {
						seven++;
					} else if (num == 8) {
						eig++;
					} else if (num == 9) {
						nine++;
					} else if (num == 10) {
						ten++;
					} 	
				}
				break;
			case 3 :
				for(int i = 1; i < count; i++) {
					System.out.println(i + "는" + i +"번 나왔습니다.");
				}
				System.out.println();
				break;
			case 4 :
				
				break;
			case 5 :
				System.out.println("프로그램 종료");
				run=false;
			}
			
		}

	}

}
