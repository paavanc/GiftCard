package com.giftcard.price.vo;

public class Gift {
	String item;
	int price;

	public Gift() {

	}

	public Gift(String item, int price) {
		this.item = item;
		this.price = price;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return this.item + " " + this.price;
	}

}
