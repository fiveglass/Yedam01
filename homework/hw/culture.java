package hw;

public abstract class culture {
	String name;
	int direct;
	int actor;
	int crowd;
	int score;
	
	public culture(String name, int direct, int actor) {
		this.name = name;
		this.direct = direct;
		this.actor = actor;
	}
	
	public void setTotalScore(int score) {
		this.score += score;
		this.crowd += 1;
	}
	
	public String getGrade() {;
	      int star = score/crowd;
	      
	      String grade = "";
	      for(int i = 1; i <= star; i++) {
	         grade += "☆";
	      } 
	      return grade;
	}
	//(String)
	//valueOf
	//intger
	public abstract void getInformation();
	
}
