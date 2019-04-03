package com.javaob.c30;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("localhost", 8888);
		InputStream is = client.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		String msg = dis.readUTF();
		System.out.println(msg);
		
		OutputStream os = client.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		dos.writeUTF("oookk");
		dos.flush();
	}
}
