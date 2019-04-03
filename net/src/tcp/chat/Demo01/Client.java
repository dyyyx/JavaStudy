package tcp.chat.Demo01;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 创建客户端： 发送数据+接收数据
 * 写出数据：输出流
 * 读取数据：输入流
 * 
 * @author 979739537
 *
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("localhost",9999);
		//控制台输入
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		String info = console.readLine();
		//写出数据 输出流
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		dos.writeUTF(info);
		dos.flush();
		//读取数据 输入流
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String msg = dis.readUTF();
		System.out.println(msg);
	}
}
