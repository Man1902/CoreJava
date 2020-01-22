package com.learning.designpattern;

import java.util.ArrayList;
import java.util.List;

interface PaymentStrategy {
	public void pay(int amount);
}

class CreditCardStrategy implements PaymentStrategy {
	private String cardNumber;
	private String cvv;

	public CreditCardStrategy(String cardNumber, String cvv) {
		this.cardNumber = cardNumber;
		this.cvv = cvv;
	}

	@Override
	public void pay(int amount) {
		System.out.println(amount + " paid with credit/debit card");
	}
}

class walletStrategy implements PaymentStrategy {
	private String mobileNo;

	public walletStrategy(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public void pay(int amount) {
		System.out.println(amount + " paid using walletStrategy.");
	}

}

class Item {

	private String upcCode;
	private int price;

	public Item(String upc, int cost) {
		this.upcCode = upc;
		this.price = cost;
	}

	public String getUpcCode() {
		return upcCode;
	}

	public int getPrice() {
		return price;
	}

}

class ShoppingCart {
	List<Item> items;

	public ShoppingCart() {
		this.items = new ArrayList<Item>();
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public void removeItem(Item item) {
		this.items.remove(item);
	}

	public int calculateTotal() {
		int sum = 0;
		for (Item item : items) {
			sum += item.getPrice();
		}
		return sum;
	}

	public void pay(PaymentStrategy paymentMethod) {
		int amount = calculateTotal();
		paymentMethod.pay(amount);
	}
}

public class B05StrategyPattern {
	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		Item item1 = new Item("1234", 10);
		Item item2 = new Item("5678", 40);

		cart.addItem(item1);
		cart.addItem(item2);

		// pay by paypal
		cart.pay(new walletStrategy("9876543210"));
	}
}
