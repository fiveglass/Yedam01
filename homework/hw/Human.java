package hw;

public class Human {
	String name;
	int height;
	int weight;

	
	Human(String name, int height, int weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}



	public void getInformation() {
		System.out.println(name);
		System.out.println(height);
		System.out.println(weight);
	}
}
