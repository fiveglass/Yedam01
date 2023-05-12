package com.yedam.value;

public class variable {
	
	public static void main(String[] args) {
		int value = 0;
		int result = value + 10; 
		// value 값에 값을 넣어주지 않으면 로컬변수 초기화 되지 않은 상태로 컴파일 에러 발생
		
		System.out.println(result);
		
		//1.변수사용
		int hour =1;
		int minute=5;
		 
		System.out.println(hour + "시간:" + minute + "분");
		
		//시간 ->분으로 변환
		int totalMinute = (hour*60) + minute;
		System.out.println("총 " + totalMinute + "분");
		
		//변수 복사
		int x = 3;
		int y;
		
		System.out.println("바꾸기전 "+x);
		
		y = x;
		System.out.println("바꾼 후" + x + y);
		
		//swap
		//x, y 값 변경 
		//대신 담아줄 수 있는 변수 선언 -> z
		x = 3;
		y = 5;
		int z = 0;
		//1)x->z (z=3)
		z=x;
		//2)y->x (x=5)
		x=y;
		//3)y->z (y=3)
		y=z;
		
		//변수 사용 범위 : if문 안에서 사용한 변수는 밖에서 사용 불가
		int v1=15;
		if(v1 >10) {
			int v2;
			v2=v1-10;
		}
		//int v3=v1+v2+5;
		
		
		
		
	}
}
