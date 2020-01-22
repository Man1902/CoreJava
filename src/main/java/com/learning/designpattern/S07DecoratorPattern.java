package com.learning.designpattern;

/** Used to modify the functionality of an object at runtime.
 *  At the same time other instances of the same class will not be affected.
 *  e.g  FileReader, BufferedReader etc
 */
interface Car { // Component interface
	void assemble();
}

class BasicCar implements Car { // Component Impl
	public void assemble() {
		System.out.print("Basic Car.");
	}
}

class CarDecorator implements Car { // Decorator
	protected Car car;

	public CarDecorator(Car c) {
		this.car = c;
	}

	public void assemble() {
		this.car.assemble();
	}
}

class SportsCar extends CarDecorator { // Concrete Decorators
	public SportsCar(Car c) {
		super(c);
	}

	public void assemble() {
		super.assemble();
		System.out.print(" Adding features of Sports Car.");
	}
}

class LuxuryCar extends CarDecorator { // Concrete Decorators
	public LuxuryCar(Car c) {
		super(c);
	}

	public void assemble() {
		super.assemble();
		System.out.print(" Adding features of Luxury Car.");
	}
}

public class S07DecoratorPattern {
	public static void main(String[] args) {
		Car car = new SportsCar(new BasicCar());
		car.assemble();
		System.out.println();
		car = new LuxuryCar(new SportsCar(new BasicCar()));
		car.assemble();

	}
}
