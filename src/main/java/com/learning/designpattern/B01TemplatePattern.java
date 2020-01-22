package com.learning.designpattern;

/*Behavioral patterns provide solution for the better interaction between objects and how to provide lose coupling and flexibility to extend easily.*/

abstract class HouseTemplate {
	public final void buildHouse() { // template method
		buildFoundation();
		buildPillars();
		buildWalls();
		System.out.println("House is built.");
	}

	// default Impl. If you don't want to override, make it private or final
	public void buildFoundation() {
		System.out.println("Building foundation with cement,iron rods and sand");
	}

	// methods to be implemented by subclasses
	public abstract void buildWalls();

	public abstract void buildPillars();
}

class WoodenHouse extends HouseTemplate {
	@Override
	public void buildWalls() {
		System.out.println("Building Wooden Walls");
	}

	@Override
	public void buildPillars() {
		System.out.println("Building Wooden Pillars");
	}
}

class GlassHouse extends HouseTemplate {
	@Override
	public void buildWalls() {
		System.out.println("Building Glass Walls");
	}

	@Override
	public void buildPillars() {
		System.out.println("Building Glass Pillars");
	}
}

public class B01TemplatePattern {
	public static void main(String[] args) {
		HouseTemplate houseTemplate = new WoodenHouse();
		houseTemplate.buildHouse();

		houseTemplate = new GlassHouse();
		houseTemplate.buildHouse();
	}

}
