package udp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
	public static void main(String[] args) throws IOException {
		//创建服务端 + 端口
		DatagramSocket server = new DatagramSocket(8888);
		//准备接收容器
		byte[] container = new byte[1024];
		//封装成包
		DatagramPacket packet = new DatagramPacket(container, container.length);
		//接收数据
		server.receive(packet);
		//分析数据
		double data = convert(packet.getData());
		int len = packet.getLength();
		System.out.println(data);
		//释放
		server.close();
	}
	
	public static double convert(byte[] data) throws IOException {
		DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
		double num = dis.readDouble();
		dis.close();
		return num;
	}
}
