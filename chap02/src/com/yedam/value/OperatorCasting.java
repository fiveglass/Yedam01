package com.yedam.value;

public class OperatorCasting {

	public static void main(String[] args) {
		byte value1 = 10;
		int value2=100;
		long value3=1000;
		
		long result=value1+value2+value3;
		
		System.out.println(result);
		
		int iValue1 = 10;
		int iValue2 = iValue1/4;
		System.out.println(iValue2);
		
		double dValue = iValue1/4.0;
		System.out.println(dValue);
		
		int x = 1;
		int y = 2;
		
		double result2 = x/y;
		System.out.println(result2);

		int value = 10+2+8;
		
		String str1=10+2+"8";
		System.out.println(str1);
		
		String str2="10"+(8+2);
		System.out.println(str2);
		
		int valueStr = Integer.parseInt(str2);
		short shortValue = Short.parseShort(str2);
		double doubleValue = Double.parseDouble(str2);
		System.out.println(doubleValue);
		boolean hValue= Boolean.parseBoolean(str2);
		
		String str3 = String.valueOf(valueStr);
		String str4 = String.valueOf(doubleValue); 
		System.out.println(str3);
		
	}

}
