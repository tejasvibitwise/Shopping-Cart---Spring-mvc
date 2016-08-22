package com.bitwise.cart;

public class CountProduct {
	
	int count=1;

//	public CountProduct() {
//		this.count = count+1;
//	}


	@Override
	public String toString() {
		return "CountProduct [count=" + count + "]";
	}


	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public int incrementCount(){
		return this.count++;
	}
	
}
