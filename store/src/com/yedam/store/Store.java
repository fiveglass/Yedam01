package com.yedam.store;

public class Store {
//	STORE_ID    NOT NULL NUMBER        
//	STORE_NAME           VARCHAR2(100) 
//	STORE_TEL            VARCHAR2(15)  
//	STORE_ADDR           VARCHAR2(100) 
//	STORE_SALES          NUMBER       
	
	private int storeId;
	private String storeName;
	private String storeTel;
	private String storeAddr;
	private int storeSales;
	
	
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreTel() {
		return storeTel;
	}
	public void setStoreTel(String storeTel) {
		this.storeTel = storeTel;
	}
	public String getStoreAddr() {
		return storeAddr;
	}
	public void setStoreAddr(String storeAddr) {
		this.storeAddr = storeAddr;
	}
	public int getStoreSales() {
		return storeSales;
	}
	public void setStoreSales(int storeSales) {
		this.storeSales = storeSales;
	}
}
