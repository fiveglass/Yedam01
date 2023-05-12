package com.yedam.nayeol;

import java.util.Calendar;

public class EnumExample {

	public static void main(String[] args) {
		//타입 변수 = 데이터
		//week는 enum의 데이터 값을 가지고 있고, today라는 변수는 오직 7가지 데이터만 가질 수 있음
		Week today = null;
		
		//Calendar : 날짜, 요일, 시간을 얻기 위한 클래스(다만, 숫자로 받아옴)
		Calendar cal = Calendar.getInstance();
		
		int week = cal.get(Calendar.DAY_OF_WEEK);
		
		switch(week) {
		case 1 : 
			today = Week.SUNDAY;
			break;
		case 2 :
			today = Week.MONDAY;
			break;
		case 3 :
			today = Week.TUESDAY;
			break;
		case 4 :
			today = Week.WEDNESDAY;
			break;
		case 5 :
			today = Week.THURSDAY;
			break;
		case 6 :
			today = Week.FRIDAY;
			break;
		case 7 :
			today = Week.SATURDAY;
			break;
		}
		

	}

}
