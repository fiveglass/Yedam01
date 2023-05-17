package test_0517;

public class DGBCard extends Card {
	
	String company="대구은행";
	String cardStaff;
	
	DGBCard(String cardNo, int validDate, int CVC, String cardStaff) {
		super(cardNo, validDate, CVC);
		this.cardStaff=cardStaff;
	}

	@Override
	public void showCardInfo() {
		System.out.println("카드정보 - Card NO, " + cardNo +
						", 유효기간 : " + validDate +
						", CVC : " + CVC + "\n" +
						"담당직원 : " + cardStaff + ", " + company);
	}
	
	
	
}
