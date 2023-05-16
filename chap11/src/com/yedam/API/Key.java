package com.yedam.API;

public class Key {
	public int key;
	
	public Key(int key) {
		this.key = key;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Key) {
			Key compare = (Key)obj;
			if(this.key == compare.key){
				return true;
			}
		} 
		
		return false;
	}
//	hashMap.put(new Key(1), "홍길동");
//	
//	String value = hashMap.get(new Key(1));
	@Override
	public int hashCode() {
		return key;
	}
	
	
	
	
	
	
	
}
