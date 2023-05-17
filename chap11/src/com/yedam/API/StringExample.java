package com.yedam.API;

import java.io.UnsupportedEncodingException;

public class StringExample {
	public static void main(String[] args) {
		//String API
		
		//byte[] -> String
		byte[] bytes = {72,101,108,108,111,32,74,97,118,97};
		
		String str1 = new String(bytes);
		System.out.println(str1);
		
		//byte[] -> String(위치를 지정), 6의 자리에서 4개
		String str2 = new String(bytes, 6, 4);
		System.out.println(str2);
		
		//chatAt()
		//인덱스 값(문자 위치)를 입력해서 해당 위치에 있는 문자 읽기
		String ssn = "010654-157984";
		char gender = ssn.charAt(7);
		System.out.println(gender);
		switch (gender) {
		case '1':
		case '3':
			System.out.println("남자");
			break;
		case '2':
		case '4':
			System.out.println("여자");
			break;
		}
		
		//equals() 문자열 비교
		String str3 = "김또치";
		String str4 = "김또치";
		String str5 = new String("김또치");
		
		if(str3.equals(str4)) {
			System.out.println("같은 문자열");
		} else {
			System.out.println("다른 문자열");
		}
		
		if(str3.equals(str5)) {
			System.out.println("같은 문자열2");
		} else {
			System.out.println("다른 문자열2");
		}
		
		//문자열 -> 바이트 배열
		String str6 = "안녕하세요";
		byte[] byte1 = str6.getBytes();
		for(byte word : byte1) {
			System.out.println(word);
		}
		
		//byte -> String
		String str7 = new String(byte1);
		System.out.println("byte->String : " + str7);
		
		//byte <-> String + encoding type
		
		try {
			//String -> byte (EUC-KR)
			byte[] byte2 = str6.getBytes("EUC-KR");
			//byte -> String (EUC-KR)
			String str8 = new String(byte2, "EUC-KR");
			System.out.println(str8);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//문자열 위치 찾기
		String subject = "자바 프로그래밍";
		int idx = subject.indexOf("그래밍");
		System.out.println(idx);
		//문자열을 못 찾았을 때
		idx = subject.indexOf("java");
		System.out.println(idx);
		
		//문자열 길이
		System.out.println(subject.length());
		
		String ssn2 = "000102-3157849";
		
		if(ssn2.length() == 14) {
			System.out.println("주민등록 번호 자리 수 맞음");
		}else {
			System.out.println("주민등록 번호 자리 수 틀림");
		}
		
		//문자열 대치(문자열 바꾸기)
		String oldStr = "자바 프로그래밍";
		String newStr = oldStr.replace("자바", "java");
		System.out.println(newStr);
		
		//문자열 자르기 - substring
		//매개변수에 따라서 자르는 방법 다름
		//1) 매개변수가 1개 일 경우 - 해당 위치로부터 뒤로 다 짤라라.
		String ssn3 = "123456-1234567";
		String firstNum = ssn3.substring(7);
		System.out.println(firstNum);
		
		//2) 매개변수가 2개 일 경우 - 시작 위치 ~ 끝나는 위치 앞! 까지 짤라라.
		String secondNum = ssn3.substring(0,6);
		System.out.println(secondNum);
		
		//대문자 -> 소문자
		String big = "ABCDEFG";
		System.out.println(big.toLowerCase());
		
		//소문자 -> 대문자
		String small = "abcdefg";
		System.out.println(small.toUpperCase());
		
		//양쪽 공백 제거
		String name = "    고희동   ";
		System.out.println(name.trim());
		
		//기본 타입 -> 문자열 변환
		String temp = String.valueOf(123);
		System.out.println(temp); //"123"
		temp = String.valueOf(true);
		System.out.println(temp); //"true"
		
		//문자열 분리하기 - split()
		//구분자를 통한 문자열 분리
		String value = "1/2/3/4/5/6/7/8/9";
		
		String[] strAry = value.split("/");
		
		for(String data : strAry) {
			System.out.println(data);
		}
		
		//isEmpty - 문자열이 비어 있는지 확인
		String empty = "";
		
		if(empty.isEmpty()) {
			System.out.println("비었음");
		}else {
			System.out.println("안 비었음");
		}
		
		//String의 단점은 보완해주는 API
		//StringBuilder, Buffer
		StringBuilder sb = new StringBuilder();
		sb.append("ye");
		sb.append("ah");
		System.out.println(sb);
		sb.deleteCharAt(1);
		System.out.println(sb);
		sb.delete(0, 1);
		System.out.println(sb);
		
		//concat - 문자열 합치기(+)
		//contains - 포함하고 있는 문자열 확인(indexOf)
		
		String str = "";
		str.endsWith("a");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
