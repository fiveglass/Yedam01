package hw;

public interface Keypad {
	public static final int NORMAL_MODE = 0;
	public static final int HARD_MODE = 1;
	
	public abstract void leftUpButton();
	public abstract void leftDownButton();
	public abstract void rightUpButton(int mode);
	public abstract void rightDownButton(int mode);
	public abstract void changeMode(int mode);
}
