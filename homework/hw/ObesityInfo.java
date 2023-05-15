package hw;

public class ObesityInfo extends StandardWeightInfo {
	double overweight;
	
	@Override
	public void getInformation() {
		System.out.println(overweight);
	}
	
	public double getObesity() {
		return overweight = (weight - rweight)/ rweight * 100;
		if()
	}
	
	
}
