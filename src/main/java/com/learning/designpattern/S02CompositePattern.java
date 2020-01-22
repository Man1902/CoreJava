package com.learning.designpattern;

import java.util.ArrayList;
import java.util.List;

/** It is used to create a structure in a way where all objects have to be treated the same way.
*   Base Component : Interface for all objects in the composition with some common methods.
*   Leaf : Implementation of Base component.
*   Composite : Consists of leaf elements and implements the operations defined in base component to all leaf objects.It also contains 
*   helper methods to add or remove leaf object.
*/
interface Shape { // Base component
	void fillColor(String color);
}
class Circle implements Shape { // Leaf object
	public void fillColor(String color) {
		System.out.println("Cirlce is filled with " + color + " color.");
	}
}
class Triangle implements Shape { // Leaf object
	public void fillColor(String color) {
		System.out.println("Triangle is filled with " + color + " color.");
	}
}
class Drawing implements Shape { // Composite object
	List<Shape> lstShape = new ArrayList<Shape>();
	public void fillColor(String color) {
		for (Shape shape : lstShape) {
			shape.fillColor(color);
		}
	}
	public void add(Shape shape) {
		this.lstShape.add(shape); // Add new Shape
	} 
	public void remove(Shape shape) {
		this.lstShape.remove(shape); // Remove Shape
	} 
	public void clear() {
		this.lstShape.clear(); // Remove all Shape
	} 
}

public class S02CompositePattern {
	public static void main(String[] args){
		Shape circle = new Circle();
		Shape triangle = new Triangle();
		Drawing drawing = new Drawing();
		drawing.add(circle);
		drawing.add(triangle);
		drawing.fillColor("red");
		drawing.remove(triangle);
		drawing.fillColor("blue");
		drawing.clear();
		drawing.fillColor("green");
		

	}
}
