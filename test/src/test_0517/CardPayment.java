package test_0517;

public class CardPayment implements Payment{
	double cardRatio;
	
	CardPayment(double cardRatio){
		this.cardRatio=cardRatio;
	}


	@Override
	public int online(int price) {
		int result = (int)(price - (1-cardRatio+Payment.ONLINE_PAYMENT_RATIO));
		return result;
	}

	@Override
	public int offline(int price) {
		int result = (int)(price - (1-cardRatio+Payment.OFFLINE_PAYMENT_RATIO));
		return result;
	}

	@Override
	public void showInfo() {
		System.out.println("온라인 결제시 총 할인율 : " + (cardRatio*Payment.ONLINE_PAYMENT_RATIO));	
		System.out.println("오프라인 결제시 총 할인율 : " + (cardRatio*Payment.OFFLINE_PAYMENT_RATIO));
	}
	
	
}
