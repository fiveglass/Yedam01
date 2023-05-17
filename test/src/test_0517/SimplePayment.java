package test_0517;

public class SimplePayment implements Payment{
	double simplePaymentRatio;
	
	SimplePayment(double simplePaymentRatio){
		this.simplePaymentRatio=simplePaymentRatio;
	}

	@Override
	public int online(int price) {
		int result = (int)(price - (1-simplePaymentRatio+Payment.ONLINE_PAYMENT_RATIO));
		return result;
	}

	@Override
	public int offline(int price) {
		int result = (int)(price - (1-simplePaymentRatio+Payment.OFFLINE_PAYMENT_RATIO));
		return result;
	}

	@Override
	public void showInfo() {
		System.out.println("온라인 결제시 총 할인율 : " + (simplePaymentRatio+Payment.ONLINE_PAYMENT_RATIO));	
		System.out.println("오프라인 결제시 총 할인율 : " + (simplePaymentRatio+Payment.OFFLINE_PAYMENT_RATIO));
		
	}
	
	
	
}
