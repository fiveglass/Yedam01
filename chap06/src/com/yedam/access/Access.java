package com.yedam.access;

public class Access {
	//접근제한자 : 필드, 메소드, 클래스 , 생성자, 인터페이스 등 사용 가능함
	//public  : 어디서든 누구나 다 사용 가능
	//protected : 같은 패키지 내에서만 사용 가능하나 패키지가 달라도 상속 관계 시 부모-자식 사용 가능
	//default : 같은 패키지 내에서만 사용 가능
	//private : 내가 속한 클래스 , 객체 내에서만 사용 가능
	
	public String free;
	protected String parent;
	//default String basic;
	private String privacy;
	
	//생성자 접근 제한 -> 객체를 생성하는 범위 제한
	//public  : 어디서든 객체 생성 가능
	//protected : 같은 패키지 내에서만 객체 생성 가능하나 패키지가 달라도 상속 관계 시 부모-자식에서는 가능
	//default : 같은 패키지 내에서만 객체 생성 가능
	//private : 객체 생성 불가능 (막음)
	//메소드
		private void info() {
			System.out.println("privete 메소드");
		}
		
		public void instead() {
			info();
		}
	
}
