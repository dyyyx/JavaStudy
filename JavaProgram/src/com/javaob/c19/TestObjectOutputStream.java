package com.javaob.c19;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestObjectOutputStream {
	public static void main(String[] args) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
		oos.writeUTF("John");
		oos.writeDouble(85.5);
		oos.writeObject(new java.util.Date());
		
		oos.close();
	}
}
