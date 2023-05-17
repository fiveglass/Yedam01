package test_0517;

public class TossCard extends Card {

	String company="Toss";
	String cardStaff;
	
	TossCard(String cardNo, String cardStaff) {
		this.cardNo=cardNo;
		this.cardStaff=cardStaff;
	}	

	@Override
	public void showCardInfo() {
		System.out.println("카드정보 - Card NO, " + cardNo + "\n" +
						"담당직원 : " + cardStaff + ", " + company);
	}
	
	
}
