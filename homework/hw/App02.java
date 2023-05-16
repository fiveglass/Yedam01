package hw;

public class App02 {

	public static void main(String[] args) {
		
		Human human = new StandardWeightInfo("홍길동", 168, 45);
		System.out.println(human.name + "의 신장 " + human.height + ", 몸무게 " + human.weight + ", 표준체중 " + ((StandardWeightInfo) human).rweight + "입니다.");
		
		human = new ObesityInfo("박돌이", 168, 90);
		double Obesity = ((ObesityInfo)human).Obesity;
		String grade="";
		if(Obesity<=18.5) {
			grade = "저체중";
		} else if(Obesity<=22.9) {
			grade = "정상";
		} else if(Obesity<=24.9) {
			grade = "과체중";
		} else {
			grade = "비만";
		}
		System.out.println(human.name + "의 신장 " + human.height + ", 몸무게 " + human.weight +  ", " + grade + "입니다.");
	
		

	}

}
