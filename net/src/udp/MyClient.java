package udp;
/**
 * ����������
 * ���Ʒ�����
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class MyClient {
	public static void main(String[] args) throws IOException {
		//�����ͻ��� + �˿�
		DatagramSocket client = new DatagramSocket(6666);
		//׼������
		String msg = "udp���";
		byte[] data = msg.getBytes();
		//���
		DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress("localhost", 8888));
		//����
		client.send(packet);
		client.close();
	}
}
