package com.javaob.c19;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDataStream {
	public static void main(String[] args) throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("temp.dat"));
		dos.writeUTF("John");
		dos.writeDouble(85.5);
		dos.writeUTF("Jim");
		dos.writeDouble(185.5);
		dos.writeUTF("George");
		dos.writeDouble(105.25);
		dos.close();
		
		DataInputStream dis = new DataInputStream(new FileInputStream("temp.dat"));
		System.out.println(dis.readUTF() + " " + dis.readDouble());
		System.out.println(dis.readUTF() + " " + dis.readDouble());
		System.out.println(dis.readUTF() + " " + dis.readDouble());
	}
}
