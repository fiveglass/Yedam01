package com.sugang.cart;

public class Cart {
	private String memberId;
	private int classNo;
	private int cartNo;
	private String cartComplete;
	private String className;
	private int classLimit;
	private int classNumber;
	
	
	
	public int getClassLimit() {
		return classLimit;
	}
	public void setClassLimit(int classLimit) {
		this.classLimit = classLimit;
	}
	public int getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getClassNo() {
		return classNo;
	}
	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}
	public int getCartNo() {
		return cartNo;
	}
	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}
	public String getCartComplete() {
		return cartComplete;
	}
	public void setCartComplete(String cartComplete) {
		this.cartComplete = cartComplete;
	}
	
	
}
