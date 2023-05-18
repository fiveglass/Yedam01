package com.yedam.map;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class HashTableExample {

	public static void main(String[] args) {
		// 로그인
		// 1)아이디확인 ->존재 ->비밀번호 확인-> 비밀번호 불일치
//						존재x -> 아이디불일치
		Map<String, String> map = new Hashtable<>();
		
		//임의 아이디 비밀번호 입력
		map.put("spring", "12");
		map.put("summer", "123");
		map.put("fall", "1234");
		map.put("winter", "12345");
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("아이디와 비밀번호를 입력해주세요");
			System.out.println("아이디 : ");
			String id = scanner.nextLine();
			System.out.println("비밀번호 : ");
			String pw = scanner.nextLine();
			System.out.println();
			
			if(map.containsKey(id)) {
				if(map.get(id).equals(pw)) {
					System.out.println("로그인");
					break;
				} else {
					System.out.println("비밀번호 불일치");
				}
			} else {
				System.out.println("아이디 미존재");
			}
		}
		
		

	}

}
