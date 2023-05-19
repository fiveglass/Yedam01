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
