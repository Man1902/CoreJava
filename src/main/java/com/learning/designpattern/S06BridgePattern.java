package com.learning.designpattern;

/** Decouple an abstraction from its implementation so that the two can vary independently.
 * It's implementation prefers Aggregation over inheritance.
 *  It involves an interface(e.g Color) which acts as a bridge which makes the functionality of concrete classes (e.g Pentagon) independent
 *   from interface implementer classes (e.g RedColor).
 *   e.g  FileReader, BufferedReader etc
 */
interface Color {
	void applyColor();
}
class RedColor implements Color {
	public void applyColor() {
		System.out.println("red.");
	}
}
class GreenColor implements Color {
	public void applyColor() {
		System.out.println("green.");
	}
}
abstract class CShape {
	protected Color color; //Composition
	public CShape(Color c) {
		this.color = c;
	}
	abstract public void applyColor();
}
class Triangle1 extends CShape {
	public Triangle1(Color c) {
		super(c);
	}
	@Override
	public void applyColor() {
		System.out.print("Triangle filled with color ");
		color.applyColor();
	}
}
class Pentagon extends CShape {
	public Pentagon(Color c) {
		super(c);
	}
	@Override
	public void applyColor() {
		System.out.print("Pentagone filled with color ");
		color.applyColor();
	}
}

public class S06BridgePattern {
	public static void main(String[] args) {
		Color red = new RedColor();
		Color green = new GreenColor();
		
		CShape triangle = new Triangle1(red);
		CShape pentagon = new Pentagon(green);
		
		triangle.applyColor();
		pentagon.applyColor();
	}
}
