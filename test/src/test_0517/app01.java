package test_0517;

public class app01 {

	public static void main(String[] args) {
		Card card = new Card("5432-4567-9534-3657", 20251203, 253);
		
		card.showCardInfo();
		
		TossCard toss = new TossCard("5432-4567-9534-3657","신빛용");
		
		toss.showCardInfo();
		
		DGBCard dgb = new DGBCard("5432-4567-9534-3657", 20251203, 253, "신빛용");
		
		dgb.showCardInfo();

	}

}
