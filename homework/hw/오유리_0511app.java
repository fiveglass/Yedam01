package hw;

import java.util.Scanner;

public class 오유리_0511app {

	public static void main(String[] args) {
		// 문제2) 다음은 키보드로부터 상품 수와 상품 가격을 입력받아서
		// 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총 합을 구하는 프로그램을 작성하세요.
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int num = 0;
		Hw[] itemnum = null;
		int sum = 0;
		int max = 0;
		
		while(run) {
			// 1) 메뉴는 다음과 같이 구성하세요.
			// 1.상품 수 | 2.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료
			System.out.println("--------------------------------------------------------");
			System.out.println("1.상품 수 | 2.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료");
			System.out.println("---------------------------------------------------------");
			
			System.out.println("선택>");
			int menu=Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1 :
				// 2) 입력한 상품 수만큼 상품명과 해당 가격을 입력받을 수 있도록 구현하세요.
				System.out.println("상품은 몇 개 인가요?");
				num=Integer.parseInt(sc.nextLine());
				break;
			case 2 :
				itemnum = new Hw[num];
				for(int i = 0; i < itemnum.length; i++) {
					Hw itemlist = new Hw();
					
					System.out.println("상품명은?");
					itemlist.itemname=(sc.nextLine());
					System.out.println("상품가격은?");
					itemlist.price=Integer.parseInt(sc.nextLine());
					
					itemnum[i]=itemlist;
				}
				break;
			case 3 : 
				// 3) 제품별 가격을 출력하세요.
				//	출력예시, "상품명 : 가격"
				for(int i=0; i<itemnum.length; i++) {
					itemnum[i].getInfo();
					System.out.println();
				}
				break;
			case 4 : 
				// 4) 분석기능은 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총합을 구합니다.
				for(int i=0; i<itemnum.length; i++) {
					sum = sum + itemnum[i].price;
					if(max<itemnum[i].price) {
						max=itemnum[i].price;
					}
				}
				System.out.println("총합 : " + sum);
				System.out.println("최고가 : " + max);
				break;
			case 5 :
				// 5) 종료 시에는 프로그램을 종료한다고 메세지를 출력하도록 구현하세요.
				System.out.println("프로그램 종료");
				run=false;
			}
		}

	}

}
