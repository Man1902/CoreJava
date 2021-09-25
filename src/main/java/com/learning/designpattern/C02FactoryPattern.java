package com.learning.designpattern;

/** Note:
 * Defines an interface for creating an object, but let subclasses decide which class to instantiate.
 * Factory design pattern uses inheritance and relies on derived class or sub class to create object
 * This pattern delegates the responsibility of initializing a class from the client to a particular factory class by creating a type of virtual constructor
 * decouple clients from creating object they need (provides abstraction between implementation and client classes)
 * It is used when we have a super class with multiple sub-classes and based on input, we need to return one of the sub-class.
 * JDK example : valueOf() method in wrapper class, Calendar.getInstance()
 **/
interface Currency {
    String getCurrencyCode();
}

class Rupee implements Currency {
    @Override
    public String getCurrencyCode() {
        return "Rs";
    }
}

class USDollar implements Currency {
    @Override
    public String getCurrencyCode() {
        return "USD";
    }
}

class CurrencyFactory {
    public static Currency createCurrency(String country) {
        if (country.equalsIgnoreCase("India")) {
            return new Rupee();
        } else if (country.equalsIgnoreCase("US")) {
            return new USDollar();
        }
        throw new IllegalArgumentException("No such currency");
    }
}

public class C02FactoryPattern {
    public static void main(String[] args) {
        Currency rupee = CurrencyFactory.createCurrency("India");
        System.out.println(rupee.getCurrencyCode());
    }
}
