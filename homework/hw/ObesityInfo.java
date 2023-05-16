package hw;

public class ObesityInfo extends StandardWeightInfo {

	double Obesity;
	
	ObesityInfo(String name, int height, int weight) {
		super(name, height, weight);
		this.Obesity = getObesity();
	}
	
	
	@Override
	public void getInformation() {
		super.getInformation();
		System.out.println(Obesity);
	}
	
	public double getObesity() {
		return ((weight - rweight) / rweight) * 100;
	}
}
