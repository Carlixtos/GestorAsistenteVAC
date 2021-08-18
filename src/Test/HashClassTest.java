package Test;

import util.KeysU;

public class HashClassTest implements KeysU{
	int key;
	String name;
	
	public HashClassTest(int key,String name) {
		this.key=key;
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getKey() {
		return key;
	}
	
	public int getIntKey() {
		return key;
	}
}
