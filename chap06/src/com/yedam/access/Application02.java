package com.yedam.access;

public class Application02 {

	public static void main(String[] args) {
		Student std = new Student();
		
		std.setStdName("김또치");
		std.setmajor("컴퓨터공학과");
		std.setStdGrade("2학년");
		std.setprograming(-5);
		std.setdatebase(50);
		std.setos(-50);

		System.out.println("이름 : " +std.getstdName());
		System.out.println("전공 : " +std.getmajor());
		System.out.println("학년 : " +std.getstdGrade());
		System.out.println("프로그래밍 : " +std.getprograming());
		System.out.println("데이터베이스 : " +std.getdatebase());
		System.out.println("운영체제 : " +std.getos());
		
		Member member = new Member();
		
		//인스턴드 필드 -> 데이터 입력
		member.setid("yedam");
		member.setpw("1234");
		member.setname("도우너");
		member.setage(-100);
		
		System.out.println(member.getid());
		System.out.println(member.getpw());
		System.out.println(member.getname());
		System.out.println(member.getage());
		
	}

}
