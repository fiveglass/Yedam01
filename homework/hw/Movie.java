package hw;

public class Movie extends culture {

	String genre;
	
	public Movie(String name, int direct, int actor) {
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
