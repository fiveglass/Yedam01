package hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringGame {
	
	Scanner sc = new Scanner(System.in);
	
	List<String> list = new ArrayList<>();
	String findChar = "";
	String oxString =""; 
	
	public void setCharData(){
		
		System.out.println("현재까지 확인된 문자열의 문자는 다음과 같습니다.");
		System.out.println(findChar);
		
		if(findChar.length()==10) {
			System.out.println("문자열을 구성하는 문자음 다 입력하셨습니다.");
			return;
		} 
		
		System.out.print("입력값>>");
		String input = sc.nextLine();
		boolean isFound = false;
		
		for(int i = 0; i<list.size(); i++) {
			if(input.equals(list.get(i))) {
				isFound = true;
				findChar = findChar+input+" ";
				break;	
			}
		}
		
		if(isFound) {
			System.out.println("문자열을 구성하는 문자입니다.");	
		}  else {
			System.out.println("문자열을 구성하는 문자가 아닙니다.");
		}
		
	}
	
	public void setStrData() {
		System.out.println("현재까지 확인된 문자열의 문자는 다음과 같습니다.");
		System.out.println(findChar);
		System.out.print("입력값>>");
		String input = sc.nextLine();
		oxString="";
		if(input.length()!=5) {
			System.out.println("입력된 문자열의 길이가 정답과 다합니다.");
		} else {
			for(int i = 0; i<list.size(); i++) {
				if(String.valueOf(input.charAt(i)).equals(list.get(i))) {
					oxString = oxString + "O "; 
				} else {
					oxString = oxString + "X ";
				}
			}
			System.out.println(oxString);
		}
		if(input.equals("smart")) {
			System.out.println("정답입니다.");
		}
		
		
	}
	
	public void showCharData() {
		System.out.println("현재까지 확인된 문자열의 문자는 다음과 같습니다.");
		System.out.println(findChar);
	}
	
	public void init() {
		list = new ArrayList<>();
		findChar = "";
		oxString="";
	}
}
