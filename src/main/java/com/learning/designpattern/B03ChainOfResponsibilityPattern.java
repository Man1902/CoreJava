package com.learning.designpattern;

class CurrencyClass {
	private int amount;

	public CurrencyClass(int amt) {
		this.amount = amt;
	}

	public int getAmount() {
		return this.amount;
	}
}

interface DispenseChain {

	void setNextChain(DispenseChain nextChain);

	void dispense(CurrencyClass currency);
}

class Dollar50Dispenser implements DispenseChain {

	private DispenseChain nextChain;

	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void dispense(CurrencyClass cur) {
		if (cur.getAmount() >= 50) {
			int num = cur.getAmount() / 50;
			int remainder = cur.getAmount() % 50;
			System.out.println("Dispensing " + num + " 50$ note");
			if (remainder != 0)
				this.nextChain.dispense(new CurrencyClass(remainder));
		} else {
			this.nextChain.dispense(cur);
		}
	}

}

class Dollar20Dispenser implements DispenseChain {

	private DispenseChain nextChain;

	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void dispense(CurrencyClass cur) {
		if (cur.getAmount() >= 20) {
			int num = cur.getAmount() / 20;
			int remainder = cur.getAmount() % 20;
			System.out.println("Dispensing " + num + " 20$ note");
			if (remainder != 0)
				this.nextChain.dispense(new CurrencyClass(remainder));
		} else {
			this.nextChain.dispense(cur);
		}
	}
}

class Dollar10Dispenser implements DispenseChain {
	private DispenseChain nextChain;

	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void dispense(CurrencyClass cur) {
		if (cur.getAmount() >= 10) {
			int num = cur.getAmount() / 10;
			System.out.println("Dispensing " + num + " 10$ note");
		}
	}
}

class ATMDispenseChain {

	private DispenseChain c1;

	public ATMDispenseChain() {
		this.c1 = new Dollar50Dispenser();
		DispenseChain c2 = new Dollar20Dispenser();
		DispenseChain c3 = new Dollar10Dispenser();

		// set the chain of responsibility
		c1.setNextChain(c2);
		c2.setNextChain(c3);
	}

	public DispenseChain getC1() {
		return c1;
	}
}

public class B03ChainOfResponsibilityPattern {

	public static void main(String[] args) {
		ATMDispenseChain atm = new ATMDispenseChain();
		atm.getC1().dispense(new CurrencyClass(230));
	}

}
