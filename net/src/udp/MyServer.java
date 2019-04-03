package udp;
/**
 * 非面向连接
 * 类似发短信
 *
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class MyServer {
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
		byte[] data = packet.getData();
		int len = packet.getLength();
		System.out.println(new String(data, 0, len));
		//释放
		server.close();
	}
}
