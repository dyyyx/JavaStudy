package com.javaob.c21;

public class GenericMethodDemo {

	public static void main(String[] args) {
		String[] strings = {"aaa", "bbb", "ccc", "vvv"};
		Integer[] integers = {1, 2, 3, 4, 5};
		GenericMethodDemo.<String>print(strings);
		GenericMethodDemo.<Integer>print(integers);
	}
	public static <E> void print(E[] list) {
		for(int i=0; i<list.length; i++) 
			System.out.print(list[i] + " ");
		System.out.println();
	}
}
