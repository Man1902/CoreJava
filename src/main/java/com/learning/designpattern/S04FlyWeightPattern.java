package com.learning.designpattern;

import java.util.HashMap;
import java.util.Map;

/** It is used when we need to create a lot of Objects. Since every object consumes memory space,this pattern can be applied to reduce 
 *  the load on memory by sharing objects.
 *  It tries to reuse already existing similar kind objects by storing them and creates new object when no matching object is found.
 *  e.g Java String class String Pool implementation
 */
interface IShape {
	void draw(String color);
}
class CircleShape implements IShape {
	public void draw(String color) {
		System.out.println("Circle -> draw -> color : " + color);
	}
}
class TriangleShape implements IShape {
	public void draw(String color) {
		System.out.println("Triangle -> draw -> color : " + color);
	}
}
final class ShapeFactory {
	private ShapeFactory(){}
	private static final Map<String, IShape> shapMap = new HashMap<String, IShape>();
	public static IShape getShape(String type) {
		IShape shapeObj = shapMap.get(type);
		if (shapeObj == null) {
			if("circle".equals(type)){
				shapeObj = new CircleShape();
			}else if("triangle".equals(type)){
				shapeObj = new TriangleShape();
			}
			shapMap.put(type, shapeObj);
			System.out.println("Creating Shape object of type "+type);
		}
		return shapeObj;
	}
}

public class S04FlyWeightPattern {
	public static void main(String[] args){
		IShape circle = ShapeFactory.getShape("circle");
		circle.draw("red");
		IShape triangle = ShapeFactory.getShape("triangle");
		triangle.draw("blue");
		
		circle = ShapeFactory.getShape("circle");
		circle.draw("green");
		triangle = ShapeFactory.getShape("triangle");
		triangle.draw("yellow");

	}
}
