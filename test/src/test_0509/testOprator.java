package test_0509;

public class testOprator {

	public static void main(String[] args) {
		// 문제1) 아래와 같이 각 변수를 초기화하였을 때 각 문제에 맞게 구현하세요.
		int x = -5;
		int y = 10;
		int result;
				
		// 1-1) 부호연산자를 이용하여 변수 x의 값을 양수로 출력하세요. 단, 변수 x의 값은 변하지 말아야한다.
		result = -x;
		System.out.printf("x : %d, result : %d\n", x, result);
		
		// 1-2) 변수 x의 값을 증가시킨 후 변수 y의 값과 더한 다음 변수 y의 값을 감소시키는 연산식을 한줄로 작성하세요.
		result = ++x + y--;
		System.out.printf("x : %d, y : %d, result : %d\n", x, y, result);
		
		// 1-3) 변수 x와 y의 값을 더한 값이 5가 되도록 증감연산자를 사용하여 연산식을 한줄로 작성하세요.
		result = --x + ++y;
		System.out.printf("x : %d, y : %d, result : %d\n", x, y, result);

		// 문제2) 아래와 같이 각 변수를 초기화하였을 때 다음 결과를 차례대로 false 와 true로 출력하도록 수정하세요.
		int m = 10;
		int n = 5;

		System.out.println( ( m*2 != n*4 ) || ( n<5 ) );		
		System.out.println( ( m/2 == 5) && ( n%2 == 1) );
		
		// 문제3) 각 연산식을 대입 연산자 하나로 구성된 연산식으로 수정하세요.
		int val = 0;

		val += 10;
			
		val -= 5;		
		
		val *= 3;
				
		val /= 5;
		
		// 문제4) 변수 val의 값이 양수일 경우엔 변수 값을, 아닐 경우엔 0을 담는 변수를 선언하세요. (단, 삼항연산자를 사용)
		int intResult = val>=0 ? val : 0;
		System.out.println(intResult);
		
		/* 문제 5) 다음과 같이 두 개의 정수가 주어졌을 경우 
		    두 정 수 중에서 음수가 있다면 'One of a or b is negative number'를,
		    만일 그렇지 않다면 'both a and b are zero or more'를 출력하도록 구현하세요. */ 
		int a = 10;
		int b = -8;
		String strResult;
		//System.out.println(strResult);

	}

}
