package com.yedam.value;

import java.util.Scanner;

public class happybirthday {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("이름을 입력해주세요.");
		String name = scanner.nextLine();
		
		System.out.println("생일을 입력해주세요.(예.9월9일)");
		String hbd = scanner.nextLine();
		if(hbd.equals("5월10일")) {
			System.out.println(name + "생일축하해!");
		} else {
			System.out.println("너 누구얏!");
		}
	}
}


