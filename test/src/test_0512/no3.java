package test_0512;

public class no3 {

	public static void main(String[] args) {
		//큰 금액부터 동전을 우선적으로 거슬러 줘야한다.
		int[] coinUnit = {500,100,50,10};
		int money = 2680;
		int fivehundred = 0;
		int onehundred = 0;
		int fif = 0;
		int ten = 0;
		
		System.out.println("money=" + money);
		
		for(int i = 0; i < coinUnit.length; i++) {
			if(money>coinUnit[0]) {
				fivehundred = money / coinUnit[0];
				money = money - (fivehundred*coinUnit[0]);
			} else if (money>coinUnit[1]) {
				onehundred = money / coinUnit[1];
				money = money - (onehundred*coinUnit[1]);
			} else if (money>coinUnit[2]) {
				fif = money / coinUnit[2];
				money = money - (fif*coinUnit[2]);
			} else if (money>coinUnit[3]) {
				ten = money / coinUnit[3];
			}
			
		}
		System.out.println("500원 : " + fivehundred + "개, " +
						"100원 : " + onehundred + "개, " +
						"50원 : " + fif + "개, " +
						"10원 : " + ten + "개");
		
	}

}
