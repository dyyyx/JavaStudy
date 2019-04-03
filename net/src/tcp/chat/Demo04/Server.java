package tcp.chat.Demo04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建服务器端： 接收数据+发送数据
 * 读取数据：输入流
 * 发送数据：输出流
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
			new Thread(channel).start();//一条道路
		}
	}
	

	
	/**
	 * 一个客户一条线程
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
				this.send("欢迎进入聊天室");
				this.sendOthers(this.name + "进入聊天室", true);
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
		 * 发送给其他客户端
		 * 
		 */
		private void sendOthers(String msg, boolean sys) {
			//判断是否为私聊
			if(msg.startsWith("@") && msg.indexOf(":")>-1) {
				String name = msg.substring(1,msg.indexOf(":"));
				String content = msg.substring(msg.indexOf(":")+1);
				for(MyChannel other:all) {
					if(other.name.equals(name)) {
						other.send(this.name+"悄悄对您地说:"+content);
						
					}
				}
			}else {
				
				//遍历容器
				for(MyChannel other:all) {
					if(other == this) {
						continue;
					}
					if(sys) {
						other.send("系统信息:"+msg);
					}else {
						//发送给其他客户端
						other.send(this.name+"对所有人说:"+msg);
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
