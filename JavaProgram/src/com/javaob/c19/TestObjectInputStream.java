package com.javaob.c19;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

public class TestObjectInputStream {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.dat"));
		String name = ois.readUTF();
		double score = ois.readDouble();
		java.util.Date data = (java.util.Date) ois.readObject();
		System.out.println(name + " " + score + " " + data);
		ois.close();
	}
}
