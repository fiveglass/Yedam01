package hw;

public class EmpDept extends Employee{

	String Dept;
	
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
	
	
	
}
