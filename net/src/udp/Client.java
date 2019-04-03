package udp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Client {
	public static void main(String[] args) throws IOException {
		//创建客户端 + 端口
		DatagramSocket client = new DatagramSocket(6666);
		//准备数据
		double num = 89.12;
		byte[] data = convert(num);
		//打包
		DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress("localhost", 8888));
		//发送
		client.send(packet);
		client.close();
		
	}
	
	/**
	 * 字节数组 数据源 + Data 输出流
	 * @throws IOException 
	 * 
	 */
	
	public static byte[] convert(double num) throws IOException {
		byte[] data = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		dos.writeDouble(num);
		dos.flush();
		
		//获取数据
		data = bos.toByteArray();
		dos.close();
		
		return data;
	}
}
