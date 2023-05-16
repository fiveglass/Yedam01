package hw;

public class application01 {
	public static void main(String[] args) {
		Keypad keypad = new RPGgame();
		
		keypad.leftUpButton();
		keypad.leftDownButton();
		keypad.changeMode();
		keypad.rightUpButton();
		keypad.rightDownButton();
		keypad.changeMode();
		keypad.rightUpButton();
		System.out.println("=================");
		
		Keypad keypad2 = new ArcadeGame();
		
		keypad2.leftUpButton();
		keypad2.rightUpButton();
		keypad2.leftDownButton();
		keypad2.changeMode();
		keypad2.rightUpButton();
		keypad2.leftUpButton();
		keypad2.rightDownButton();
	}
	
}
