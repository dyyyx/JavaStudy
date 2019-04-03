package com.javaob.c13;

public class CircleWithException1 {
	private double radius;
	
	private static int numberOfObjects = 0;
	public CircleWithException1() {
		this(1.0);
	}
	public CircleWithException1(double radius) {
		this.radius = radius;
		numberOfObjects++;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) throws InvalidRadiusException {
		if(radius>=0) {
			this.radius = radius;
		}else {
			throw new InvalidRadiusException(radius);
		}
	}
	public static int getNumberOfObjects() {
		return numberOfObjects;
	}
	public double findArea() {
		return radius * radius * 3.1415926;
	}
	public static void main(String[] args) {
		try {
			CircleWithException1 c = new CircleWithException1(4);
			c.setRadius(-5);
		} catch (InvalidRadiusException e) {
			System.out.println("The invalid radius is " + e.getRadius());
		}
	
		System.out.println("Number of objects created:" + CircleWithException.getNumberOfObjects());
	}
}
