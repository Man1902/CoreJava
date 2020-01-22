package com.learning.designpattern;

/** It Hides the complexities of the system and provides an interface to the client using which the client can access the system. 
 *  It involves a single class which provides simplified methods required by client and delegates calls to methods of existing system classes.
 */
class ShapeMaker { // Facade class expose to client
	private Circle circle;
	private Triangle triangle;

	public ShapeMaker() {
		circle = new Circle();
		triangle = new Triangle();
	}

	public void drawCircle() {
		circle.fillColor("Red");
	}

	public void drawTriangle() {
		triangle.fillColor("Green");
	}
}

public class S05FacadePattern {
	public static void main(String[] args) {
		ShapeMaker shapeMaker = new ShapeMaker();
		shapeMaker.drawCircle();
		shapeMaker.drawTriangle();
	}
}
