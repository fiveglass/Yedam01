package test_0509;

import java.util.Scanner;

public class testLoop2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int randomNo = (int) (Math.random()*100)+1;
		
		
		for(int i=1; i<=5; i++) {
			System.out.println("번호를 맞춰보세요.");
			int chance = Integer.parseInt(sc.nextLine());
			if(randomNo==chance) {
				System.out.println("정답입니다."+ i + "번째 맞추셨습니다.");
				break;
			} else if (randomNo < chance) {
				System.out.println("down");
			} else if (randomNo > chance) {
				System.out.println("up");
			} 
			if(i==5) {
				System.out.println("randomnumber is " + randomNo +  "\n" + "Game Over");
				}
		}
		

	
	}

}
