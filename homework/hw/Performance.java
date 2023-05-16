package hw;

public class Performance extends culture {

	String genre;
	
	public Performance(String name, int direct, int actor) {
		super(name, direct, actor);
	}
	
	public void getInformation() {
		System.out.println(name);
		System.out.println(direct);
		System.out.println(actor);
		System.out.println(crowd);
		System.out.println(score);
		System.out.println(getGrade());
	}
}
