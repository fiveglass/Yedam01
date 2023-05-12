package com.yedam.oop;

import java.util.Scanner;

public class Application06 {

	public static void main(String[] args) {
		Student[] stunum = null;
		int studentnum = 0;
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int sum = 0;
		int avg = 0;
		int max = 0;
		int min = 0;
		
		while(run) {
			System.out.println("------------------------------------------------");
			System.out.println("1.학생수 | 2.정보입력 | 3.정보확인 | 4.분석 | 5.종료");
			System.out.println("-------------------------------------------------");
			
			System.out.println("선택>");
			int menu=Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1 : 
				System.out.println("학생 수는 몇 명 인가요?");
				studentnum=Integer.parseInt(sc.nextLine());
				break;
			case 2 :
				stunum = new Student[studentnum];
				
				for(int i=0; i<stunum.length; i++) {
					Student student = new Student();
					
					System.out.println("이름?");
					student.name=sc.nextLine();
					System.out.println("학년?");
					student.grade=Integer.parseInt(sc.nextLine());
					System.out.println("국어?");
					student.kor=Integer.parseInt(sc.nextLine());
					System.out.println("영어?");
					student.eng=Integer.parseInt(sc.nextLine());
					System.out.println("수학?");
					student.math=Integer.parseInt(sc.nextLine());
					
					stunum[i]=student;
				}
				break;
			case 3 :
				for(int i=0; i<stunum.length; i++) {
					stunum[i].getInfo();
					System.out.println();
				}
				break;
			case 4 :
				for(int i=0; i<stunum.length; i++) {
					sum = sum + stunum[i].kor+stunum[i].eng+stunum[i].math;
					avg = sum/stunum.length+1;
					//최대, 최소
					max = stunum[i].kor;
					min = stunum[i].kor;
					
					if(stunum[i].eng<stunum[i].math) {
						if(max<stunum[i].math) {
							max=stunum[i].math;
						}else {
							if(max<stunum[i].eng) {
								max=stunum[i].eng;
							}
						}
					}
					
					if(stunum[i].eng>stunum[i].math) {
						if(min>stunum[i].math) {
							min=stunum[i].math;
						}else{
							if(min>stunum[i].eng) {
								min=stunum[i].eng;
							}
						}
					}
				}
				System.out.println("총합" + sum);
				System.out.println("평균" + avg);
				System.out.println("최소" + min);
				System.out.println("최대" + max);
				break;
			case 5 :
				System.out.println("프로그램 종료");
				run = false;
			}
			
			
		}
		//4.분석(총합, 평균, 최대, 최소)
	}

}
