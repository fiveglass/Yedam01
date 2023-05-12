package test_0512;

import java.util.Scanner;

public class no4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int gugudan;
		
		System.out.println("몇 단을 출력하시겠습니까?");
		int dan=Integer.parseInt(sc.nextLine());
		
		System.out.println("몇까지 곱하시겠습니까?");
		int no=Integer.parseInt(sc.nextLine());
		
		if(no>dan) {
			System.out.println("단이 곱하는 수보다 큽니다.");
		} else if(no==dan || no<dan) {
			for(int i = 1; i <= no; i++) {
				gugudan = dan*i;
				System.out.println(dan +"*" + i + "=" + gugudan);
			}
		}
		
		

	}

}
