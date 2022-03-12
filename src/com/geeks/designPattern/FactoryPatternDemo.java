package com.geeks.designPattern;

public class FactoryPatternDemo {

	public static void main(String[] args) {
		ShapeFactory s = new ShapeFactory();
		Shape circle=s.getShapeType("Rectangle");
		circle.draw();
	}

}

interface Shape {
	void draw();
}

class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("I am Rectangle");
	}

}

class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("I am Circle");
	}

}

class Square implements Shape {

	@Override
	public void draw() {
		System.out.println("I am Square");
	}

}

class ShapeFactory {
	public Shape getShapeType(String shape) {
		if (shape == null)
			return null;
		else if (shape == "Circle")
			return new Circle();
		else if (shape == "Square")
			return new Square();
		else if (shape == "Rectangle")
			return new Rectangle();
		return null;
	}
}
