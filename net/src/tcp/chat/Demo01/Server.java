package tcp.chat.Demo01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * �����������ˣ� ��������+��������
 * ��ȡ���ݣ�������
 * �������ݣ������
 * 
 * @author 979739537
 *
 */
public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(9999);
		Socket client = server.accept();
		
		//��ȡ���� ������
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String msg = dis.readUTF();
		//д������ �����
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		dos.writeUTF("������-->" + msg);
		dos.flush();
		
	}
}