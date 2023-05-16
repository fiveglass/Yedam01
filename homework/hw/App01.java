package hw;

public class App01 {

	public static void main(String[] args) {
		EmpDept emp = new EmpDept("이지나", 3000, "교육부");
		
		System.out.print("이름 : " + emp.name + "\t");
		System.out.print("연봉 : " + emp.salay + "\t");
		System.out.println("부서 : " + emp.Dept);
		
		emp.print();
		

	}

}
