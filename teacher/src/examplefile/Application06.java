package examplefile;

import java.util.Scanner;

public class Application06 {
	public static void main(String[] args) {
		// 학생의 정보를 관리하는 프로그램

		// 1. 학생수
		// 2. 정보 입력
		// 3. 정보 확인
		// 4. 분석 - 전체 학생의 점수를 총합(국+영+수)
		// - 총합의 평균(학생수의 평균)
		// - 개인별 가장 점수가 높은 과목 / 낮은 과목
		// 5. 종료

		// 학생의 정보를 보관 배열
		Student[] stdAry = null;

		// 학생의 정보를 몇명 보관하는 변수
		int stdNum = 0;

		// 데이터 입력을 받을 수 있는 스캐너
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("=====================================");
			System.out.println("1.학생수|2.정보입력|3.정보확인|4.분석|5.종료");
			System.out.println("=====================================");

			int selectNo = Integer.parseInt(sc.nextLine());

			if (selectNo == 1) {
				System.out.println("학생 수 입력>");
				stdNum = Integer.parseInt(sc.nextLine());
			} else if (selectNo == 2) {
				stdAry = new Student[stdNum];

				for (int i = 0; i < stdAry.length; i++) {
					// 배열에 바로 객체를 만듬.
					stdAry[i] = new Student();

					System.out.println("이름>");
					stdAry[i].stdName = sc.nextLine();

					System.out.println("학년>");
					stdAry[i].stdNo = Integer.parseInt(sc.nextLine());

					System.out.println("국어>");
					stdAry[i].kor = Integer.parseInt(sc.nextLine());

					System.out.println("영어>");
					stdAry[i].eng = Integer.parseInt(sc.nextLine());

					System.out.println("수학>");
					stdAry[i].math = Integer.parseInt(sc.nextLine());
				}
			} else if (selectNo == 3) {
				for (int i = 0; i < stdAry.length; i++) {
					stdAry[i].getInfo();
				}
			} else if (selectNo == 4) {
				// 4. 분석 - 전체 학생의 점수를 총합(국+영+수)
				// - 총합의 평균(학생수의 평균)
				// - 개인별 가장 점수가 높은 과목 / 낮은 과목
				// 총합, 평균
				int total = 0;
				double avg = 0;
				int max = 0;
				int min = 0;
				for (int i = 0; i < stdAry.length; i++) {
					// 반복문 돌때마다 누적 합계
					total = total + stdAry[i].kor + stdAry[i].eng + stdAry[i].math;

					max = stdAry[i].kor;
					min = stdAry[i].kor;
					//최대, 최소값 구하는 반복
					//2) 한명 국어[0], 수학[1], 영어[2] -> 또다른 배열 -> 반복
					//1) if문
					if (stdAry[i].eng < stdAry[i].math) {
						if (max < stdAry[i].math) {
							max = stdAry[i].math;
						}
					}else {
						if(max < stdAry[i].eng) {
							max = stdAry[i].eng;
						}
					}
				}
				
				System.out.println("총 합 : " + total);
				System.out.println("평 균 : " + (double)total/stdAry.length);
			} else if (selectNo == 5) {
				System.out.println("프로그램 종료");
				break;
			}
		}

	}
}
