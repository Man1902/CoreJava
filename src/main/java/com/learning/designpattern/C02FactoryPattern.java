package com.learning.designpattern;

interface RBI {
	double getInterestRate();
}

class SBI implements RBI {
	private double interestRate;

	public SBI(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public double getInterestRate() {
		return this.interestRate;
	}
}

class BOB implements RBI {
	private double interestRate;

	public BOB(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public double getInterestRate() {
		return this.interestRate;
	}
}

final class RBIFactory {
	private RBIFactory() {
	}

	public static RBI getInstance(String bank, double intrestRate) {
		RBI bankObj = null;
		switch (bank) {
		case "SBI":
			bankObj = new SBI(intrestRate);
			break;
		case "BOB":
			bankObj = new BOB(intrestRate);
			break;

		}
		return bankObj;
	}
}

public class C02FactoryPattern {
	public static void main(String[] args) {
		RBI sbiObj = RBIFactory.getInstance("SBI", 7.5);
		System.out.println("Interest Rate is : " + sbiObj.getInterestRate());

		RBI bobObj = RBIFactory.getInstance("BOB", 7);
		System.out.println("Interest Rate is : " + bobObj.getInterestRate());
	}
}
