package hw;

public class EmpDept extends Employee{
		String Dept;
		
		//아래쪽이 없으면 EmpDept에 빨간줄? 기본 생성자가 없는 클래스를 상속 받은 경우 슈퍼클래스 생성자 호출 필요
		//슈퍼클래스?  부
		EmpDept(String name, int salay, String Dept) {
			super(name, salay);
			this.Dept = Dept;
		}
	
		@Override
		public void getInformation() {
			System.out.println(name);
			System.out.println(salay);
			System.out.println(Dept);
		}
	
		@Override
		public void print() {
			System.out.println("슈퍼클래스\n서브클래스");
		}

		public String getDept() {
			return Dept;
		}
		
		
}
