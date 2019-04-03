package com.javaob.c29;

public class RaceApp {
	public static void main(String[] args) {
		Rabbit r = new Rabbit();
		Tortorise t = new Tortorise();
		
		r.start();
		t.start();
		
		for(int i = 0; i < 100; i++) {
			System.out.println("main----->" + i + "²½");
		}
	}
}
