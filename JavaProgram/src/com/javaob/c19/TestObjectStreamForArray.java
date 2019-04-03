package com.javaob.c19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestObjectStreamForArray {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		int[] numbers = {1, 2, 3, 4, 5};
		String[] strings = {"John", "Jim", "Jake"};
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("array.dat", true));
		oos.writeObject(numbers);
		oos.writeObject(strings);
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("array.dat"));
		int[] newNumbers = (int[]) ois.readObject();
		String[] newStrings = (String[]) ois.readObject();
		for(int i=0;i<newNumbers.length;i++) {
			System.out.print(newNumbers[i] + " ");
		}
		System.out.println();
		for(int i=0;i<newStrings.length;i++) {
			System.out.print(newStrings[i] + " ");
		}
	}
}
