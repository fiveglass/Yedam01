package test_0517;

public class Person {
	String ssn;
	String name;
	String address;
	
	Person(){}
	
	Person(String ssn, String name, String address){
		this.ssn = ssn;
		this.name = name;
		this.address = address;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
