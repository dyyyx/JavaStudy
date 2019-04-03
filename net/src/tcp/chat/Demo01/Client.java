package tcp.chat.Demo01;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �����ͻ��ˣ� ��������+��������
 * д�����ݣ������
 * ��ȡ���ݣ�������
 * 
 * @author 979739537
 *
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("localhost",9999);
		//����̨����
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		String info = console.readLine();
		//д������ �����
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		dos.writeUTF(info);
		dos.flush();
		//��ȡ���� ������
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String msg = dis.readUTF();
		System.out.println(msg);
	}
}
