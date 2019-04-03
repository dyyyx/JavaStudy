package com.javaob.c13;

public class InvalidRadiusException extends Exception{
	private double radius;
	
	public InvalidRadiusException(double radius) {
		super("invalid radius" + radius);
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
}
