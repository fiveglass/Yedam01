package com.yedam.print;

import java.io.IOException;
import java.util.Scanner;

public class KeyCode {

	public static void main(String[] args) throws IOException {
		//KeyCode -> 하나의 문자만 받아 올 때
		 System.out.println("입력>");
		 
		 int keyCode = 0;
		 
		 keyCode = System.in.read();
		 System.out.println("KeyCode : " + keyCode);

		 keyCode = System.in.read();
		 System.out.println("KeyCode : " + keyCode);

		 keyCode = System.in.read();
		 System.out.println("KeyCode : " + keyCode);
		 
		 //Scanner
		 //nextLine(); : enter키 이전까지 기준으로 데이터 받아옴
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("입력>");
		 
		 String inputData = scanner.nextLine();
		 //int data = scanner.nextLine();
		 //System.out.println("Scanner 활용 => "+ data);
		 //enter키 소멸
		 scanner.nextLine();
		 
		 //데이터비교 : 입력한 값과 지정된 값 비교
		 
		 //기본타입 정수, 실수 비교
		 //문자열 비교 : equals
		 if(inputData.equals("yedam")) {
			 System.out.println("yedam과 일치합니다.");
		 }
 
	}

}
