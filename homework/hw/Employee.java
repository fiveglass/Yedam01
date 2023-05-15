package hw;

public class Employee {
	//필드
	String name;
	int salay;
	
	//생성자
	Employee(String name, int salay){
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
}
