package com.javaob.c30;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8888);
		Socket socket = server.accept();
		System.out.println("һ���ͻ��˽�������");
		String msg = "��ӭʹ��";
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(msg);
		dos.flush();
		
		InputStream in = socket.getInputStream();
		DataInputStream dis = new DataInputStream(in);
		msg = dis.readUTF();
		System.out.println(msg);
	}
}
