package com.test.exe;

public class Coffee {
		//	MENU    NOT NULL VARCHAR2(30)   
		//	PRICE   NOT NULL NUMBER         
		//	EXPLAIN          VARCHAR2(1000) 
		//	SALES            NUMBER 
			private String menu;
			private int price;
			private String explain;
			private int sales;
			
			private int salesSum;
			
			public int getSalesSum() {
				return salesSum;
			}
			public void setSalesSum(int salesSum) {
				this.salesSum = salesSum;
			}
			public String getMenu() {
				return menu;
			}
			public void setMenu(String menu) {
				this.menu = menu;
			}
			public int getPrice() {
				return price;
			}
			public void setPrice(int price) {
				this.price = price;
			}
			public String getExplain() {
				return explain;
			}
			public void setExplain(String explain) {
				this.explain = explain;
			}
			public int getSales() {
				return sales;
			}
			public void setSales(int sales) {
				this.sales = sales;
			}
}
