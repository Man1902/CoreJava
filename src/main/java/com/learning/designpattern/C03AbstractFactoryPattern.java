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
        return interestRate;
    }
}

interface BankFactory {
    RBI getInstance();
}

class SBIFactory implements BankFactory {
    private double interestRate;

    public SBIFactory(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public RBI getInstance() {
        return new SBI(this.interestRate);
    }
}

final class RBIAbstractFactory {
    private RBIAbstractFactory() {
    }

    public static RBI getInstance(BankFactory bankFactory) {
        return bankFactory.getInstance();
    }
}

public class C03AbstractFactoryPattern {
    public static void main(String[] args) {
        SBIFactory sbiFactory = new SBIFactory(7.5);
        RBI bankObj = RBIAbstractFactory.getInstance(sbiFactory);
        System.out.println("Interest Rate is : " + bankObj.getInterestRate());
    }
}
