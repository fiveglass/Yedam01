package hw;

public class Hw {	
	String itemname;
	int price;
	
	Hw(){}
	
	Hw(String itemname, int price){
		this.itemname = itemname;
		this.price = price;
	}
	
	void getInfo() {
		System.out.println(
				"제품별 가격" +
				"상품명 : " + itemname +
				", 가격 : " + price
				);
	}
}
