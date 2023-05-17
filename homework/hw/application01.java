package hw;

public class application01 {
	public static void main(String[] args) {
		Keypad keypad = new RPGgame();
		
		keypad.leftUpButton();
		keypad.rightUpButton();
		keypad.changeMode();
		keypad.rightUpButton();
		keypad.rightDownButton();
		keypad.changeMode();
		keypad.rightDownButton();
		System.out.println("=================");
		
		keypad = new ArcadeGame();
		
		keypad.leftUpButton();
		keypad.rightUpButton();
		keypad.leftDownButton();
		keypad.changeMode();
		keypad.rightUpButton();
		keypad.leftUpButton();
		keypad.rightDownButton();
	}
}
