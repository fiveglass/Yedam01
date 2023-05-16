package hw;

public class App03 {

	public static void main(String[] args) {
		Movie mv = new Movie("추격자", 7, 5);
		mv.setTotalScore(4);
		mv.setTotalScore(4);
		mv.setTotalScore(4);
		System.out.println("영화제목 : " + mv.name);
		System.out.println("감독 : " + mv.direct);
		System.out.println("배우 : " + mv.actor);
		System.out.println("영화총점 : " + mv.score);
		System.out.println("영화평점 : " + mv.getGrade());
		System.out.println("=========================");
		
		Performance pf = new Performance("지킬앤하이드", 9, 10);
		pf.setTotalScore(3);
		pf.setTotalScore(3);
		pf.setTotalScore(3);
		System.out.println("공연제목 : " + pf.name);
		System.out.println("감독 : " + pf.direct);
		System.out.println("배우 : " + pf.actor);
		System.out.println("공연총점 : " + pf.score);
		System.out.println("공연평점 : " + pf.getGrade());

	}

}
