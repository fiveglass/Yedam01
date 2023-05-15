package hw;

public class App01 {

	public static void main(String[] args) {
		EmpDept emp = new EmpDept("오유리", 5000, "IT");
		
		System.out.print("이름 : " + emp.name);
		System.out.print("연봉 : " + emp.salay);
		System.out.println("부서 : " + emp.Dept);
		
		emp.print();
		
		

	}

}
