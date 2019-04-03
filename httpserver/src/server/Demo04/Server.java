package server.Demo04;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import util.CloseUtil;

public class Server {
	private ServerSocket server;
	public static final String CRLF = "\r\n";
	public static final String BLANK = " ";
	private boolean isShutDown = false;
	
	public static void main(String[] args) {
		
		Server server = new Server();
		server.start();
		
	}
	/**
	 * ����������
	 */
	public void start() {
		start(8888);
	}
	/**
	 * ����ָ���˿ڷ�����
	 */
	public void start(int port) {
		try {
			server = new ServerSocket(port);
			this.receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			stop();
		}
		
	}
	/**
	 * ���տͻ���
	 */
	private void receive() {
		try {
			while(!isShutDown) {
				new Thread(new Dispatcher(server.accept())).start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}
	public void stop() {
		isShutDown = true;
		CloseUtil.closeSocket(server);
	}
}