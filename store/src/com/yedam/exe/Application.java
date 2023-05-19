package com.yedam.exe;

import java.util.Scanner;

import com.yedam.store.StoreService;

public class Application {
	Scanner sc = new Scanner(System.in);

	public Application() {
		run();
	}

	private void run() {
		StoreService ss = new StoreService();
		while (true) {
			System.out.println("1. 모든 가게 정보 조회 | 2. 지역구별 매출 조회" + " | 3. 가게 정보 입력 | 4. 매출 수정");
			int menu = Integer.parseInt(sc.nextLine());

			if (menu == 1) {
				ss.getStoreList();
			} else if (menu == 2) {
				ss.getStoreSales();
			} else if (menu == 3) {
				ss.insertStore();
			} else if (menu == 4) {
				ss.updateSales();
			}

		}

	}
}
