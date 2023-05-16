package hw;

public class ArcadeGame implements Keypad {
	int mode=0;

	@Override
	public void leftUpButton() {
		System.out.println("캐릭터가 앞쪽으로 이동한다.");
	}

	@Override
	public void leftDownButton() {
		System.out.println("캐릭터가 뒤쪽으로 이동한다.");
		
	}

	@Override
	public void rightUpButton(int mode) {
		if(mode==0) {
			System.out.println("캐릭터가 일반 공격");
		} else if(mode==1) {
			System.out.println("캐릭터가 연속 공격");
		}
		
	}

	@Override
	public void rightDownButton(int mode) {
		if(mode==0) {
			System.out.println("캐릭터가 HIT 공격.");
		} else if(mode==1) {
			System.out.println("캐릭터가 Double HIT 공격.");
		}
		
	}

	@Override
	public void changeMode(int mode) {
		if(mode==0) {
			System.out.println("NORMAL_MODE");
			this.mode = Keypad.HARD_MODE;
		} else if(mode==1) {
			System.out.println("HARD_MODE");
			this.mode = Keypad.NORMAL_MODE;
		} 
		
	}
	
	
}
