package tcp.chat.Demo04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * �����������ˣ� ��������+��������
 * ��ȡ���ݣ�������
 * �������ݣ������
 * 
 * @author 979739537
 *
 */
public class Server {
	private List<MyChannel> all = new ArrayList<MyChannel>();
	public static void main(String[] args) throws IOException {
		new Server().start();
		
	}
	
	
	public void start() throws IOException {
		ServerSocket server = new ServerSocket(9999);
		while(true) {
			Socket client = server.accept();
			MyChannel channel = new MyChannel(client);
			all.add(channel);
			new Thread(channel).start();//һ����·
		}
	}
	

	
	/**
	 * һ���ͻ�һ���߳�
	 * 
	 */
	private class MyChannel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private boolean isRunning = true;
		private String name;
		public MyChannel(Socket client) {
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				this.name = dis.readUTF();
				this.send("��ӭ����������");
				this.sendOthers(this.name + "����������", true);
			} catch (IOException e) {
				CloseUtil.closeAll(dos, dis);
				isRunning = false;
			}
		}
		
		private String receive() {
			String msg = "";
			try {
				msg = dis.readUTF();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				CloseUtil.closeAll(dis);
				isRunning = false;
				all.remove(this);
			}
			
			return msg;
		}
		
		private void send(String msg) {
			if(null == msg || msg.equals("")) {
				return;
			}
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				// TODO: handle exception
				CloseUtil.closeAll(dos);
				isRunning = false;
				all.remove(this);
				
			}
		}
		
		/**
		 * ���͸������ͻ���
		 * 
		 */
		private void sendOthers(String msg, boolean sys) {
			//�ж��Ƿ�Ϊ˽��
			if(msg.startsWith("@") && msg.indexOf(":")>-1) {
				String name = msg.substring(1,msg.indexOf(":"));
				String content = msg.substring(msg.indexOf(":")+1);
				for(MyChannel other:all) {
					if(other.name.equals(name)) {
						other.send(this.name+"���Ķ�����˵:"+content);
						
					}
				}
			}else {
				
				//��������
				for(MyChannel other:all) {
					if(other == this) {
						continue;
					}
					if(sys) {
						other.send("ϵͳ��Ϣ:"+msg);
					}else {
						//���͸������ͻ���
						other.send(this.name+"��������˵:"+msg);
					}
				}
			}
		}
	
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(isRunning) {
				sendOthers(receive(), false);
			}
		}
		
	}
}
