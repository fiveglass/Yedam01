package hw;

public class StandardWeightInfo extends Human {
	double rweight;
	
	StandardWeightInfo(String name, int height, int weight) {
		super(name, height, weight);
		this.rweight = getStandardWeight();
	}
	
	@Override
	public void getInformation() {
		super.getInformation();
		System.out.println(rweight);
	}
	
	public double getStandardWeight() {
		return (height - 100) * 0.9;
	}
}
