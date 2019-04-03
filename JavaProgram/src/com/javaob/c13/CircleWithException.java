package com.javaob.c13;

public class CircleWithException {
	private double radius;
	private static int numberOfObjects = 0;
	public CircleWithException() {
		this(1.0);
	}
	public CircleWithException(double radius) {
		setRadius(radius);
		numberOfObjects++;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) throws IllegalArgumentException{
		if(radius>0) {
			this.radius = radius;
		}else {
			throw new IllegalArgumentException("半径不能小于等于0");
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
			CircleWithException c1 = new CircleWithException(5);
			CircleWithException c2 = new CircleWithException(-5);
			CircleWithException c3 = new CircleWithException(0);
		}
		catch(IllegalArgumentException ex){
			System.out.println(ex);
		}
		System.out.println("Number of objects created:" + CircleWithException.getNumberOfObjects());
	}
}
