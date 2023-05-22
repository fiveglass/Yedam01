package com.yedam.member;

public class Member {
//	MEMBER_ID   NOT NULL VARCHAR2(20) 
//	MEMBER_PW            VARCHAR2(20) 
//	MEMBER_NAME          VARCHAR2(12) 
//	MEMBER_AUTH          CHAR(1)    
	
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberAuth;
	//계좌조회를 위한 필드추가
	private String account_id;
	private int accountBalance;
	
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberAuth() {
		return memberAuth;
	}
	public void setMemberAuth(String memberAuth) {
		this.memberAuth = memberAuth;
	}
	
}
