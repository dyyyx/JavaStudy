package tcp.chat.Demo02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器端： 接收数据+发送数据
 * 读取数据：输入流
 * 发送数据：输出流
 * 
 * @author 979739537
 *
 */
public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(9999);
		Socket client = server.accept();
		DataInputStream dis = new DataInputStream(client.getInputStream());
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		while(true) {
			String msg = dis.readUTF();
			System.out.println(msg);
			dos.writeUTF("服务器-->" + msg);
			dos.flush();
		}
	}
}
