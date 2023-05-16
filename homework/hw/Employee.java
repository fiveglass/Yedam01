package hw;

public class Employee {
	//필드
		String name;
		int salay;
		
		//생성자
		//기본생성자가 아닌 생성자가 있을 경우, 기본 생성자를 사용하고 싶다면 기본 생성자도 만들어 주어야 함 
		Employee(String name, int salay) {
			this.name = name;
			this.salay = salay;
		}
		
		//메소드
		public void getInformation() {
			System.out.println(name);
			System.out.println(salay);
		}
		
		public void print() {
			System.out.println("슈퍼클래스");
		}

		//해당필드값을 가져오기 위해서 사용 
		public String getName() {
			return name;
		}


		public int getSalay() {
			return salay;
		}

		
		
		
}


