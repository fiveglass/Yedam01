package com.yedam.inheri;

public class Application01 {

	public static void main(String[] args) {
		//자식의 객체를 생성하여서 상속(부모-자식) 관계에 있는 필드, 메소드를 사용가능
		SmartPhone sp = new SmartPhone("아이폰", "스그", "SK");
		
		//부모 Class 필드
		System.out.println("모델" + sp.model);
		System.out.println("색상" + sp.color);
		//자식 Class 필드
		System.out.println("통신사" + sp.agency);

		//부모 Class 메소드
		sp.powerOn();
		sp.bell();
		sp.hangup();
		sp.powerOff();
		//자식 Class 메소드
		sp.kakaoExe();
		sp.kakaoExit();
		
	}

}
