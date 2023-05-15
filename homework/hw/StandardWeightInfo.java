package hw;

public class StandardWeightInfo extends Human {
	double rweight;
	
	@Override
	public void getInformation() {
		System.out.println(rweight);
	}
	
	public double getStandardWeight() {
		return rweight = (height - 100) * 0.9;
	}
	
}
