package hw;

import java.util.Scanner;

public class application03 {

	public static void main(String[] args) {
		Keypad game;
		
		int result=(int)(Math.random()*2)+1;
		
		if(result == 1) {
			game = new RPGgame();
		} else  {
			game = new ArcadeGame();
		}
		
		boolean play = true;
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		
		while(play) {
			System.out.println("============================================================================================");
			System.out.println("<< 1.LeftUP | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT >>");
			System.out.println("============================================================================================");
			System.out.print("choice>>");
			choice = sc.nextInt();
			
			switch (choice) {
			case 1 : 
				game.leftUpButton();
				break;
			case 2 : 
				game.leftDownButton();
				break;
			case 3 : 
				game.rightUpButton();
				break;
			case 4 : 
				game.rightDownButton();
				break;
			case 5 : 
				game.changeMode();
				break;
			case 0 : 
//				if(game instanceof RPGgame) {
//					game = new ArcadeGame();
//				} else if(game instanceof ArcadeGame) {
//					game = new RPGgame();
//				}
				if(result==1) {
					game = new ArcadeGame();
				} else {
					game = new RPGgame();
				}
				break;
			case 9 : 
				System.out.println("EXIT");
				play=false;
			}
			
			
		}

	}

}
