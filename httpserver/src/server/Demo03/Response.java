package server.Demo03;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

import util.CloseUtil;

public class Response {
	public static final String CRLF = "\r\n";
	public static final String BLANK = " ";
	//��
	private BufferedWriter bw;
	//����
	private StringBuilder content;
	
	//�洢ͷ��Ϣ
	private StringBuilder headInfo;
	//�洢���ĳ���
	private int len;
	public Response() {
		headInfo = new StringBuilder();
		content = new StringBuilder();
		len = 0;
	}
	public Response(Socket client) {
		this();
		try {
			bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			headInfo = null;
			
		}
		
	}
	public Response(OutputStream os) {
		this();
		bw = new BufferedWriter(new OutputStreamWriter(os));
		
	}
	/**
	 * ��������
	 * @return 
	 */
	public Response print(String info) {
		content.append(info);
		len += info.getBytes().length;
		return this;
	}
	/**
	 * ��������+�س�
	 */
	public Response println(String info) {
		content.append(info).append(CRLF);
		len += (info + CRLF).getBytes().length;
		return this;
		
	}
	/**
	 *������Ӧͷ 
	 * 
	 */
	private void createdHeadInfo(int code) {
		//HTTPЭ��汾��״̬���롢����
		headInfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
		switch(code) {
			case 200:
				headInfo.append("OK");
				break;
			case 404:
				headInfo.append("NOT FOUND");
				break;
			case 500:
				headInfo.append("SERVE ERROR");
				break;
		} 
		headInfo.append(CRLF);
		//��Ӧͷ
		headInfo.append("Server:dyx Server/0.0.1").append(CRLF);
		headInfo.append("Data:").append(new Date()).append(CRLF);
		headInfo.append("Content-type:text/html;charset=GBK").append(CRLF);
			//���ĳ��ȣ��ֽڳ���
		headInfo.append("Content-Length:").append(len).append(CRLF);
		headInfo.append(CRLF);
	}
	//���͵��ͻ���
	void pushToClient(int code) throws IOException {
		if(null == headInfo) {
			code = 500;
		}
		createdHeadInfo(code);
		//ͷ��Ϣ+�ָ���
		bw.append(headInfo.toString());
		//����
		bw.append(content.toString());
		bw.flush();
	}
	public void close() {
		CloseUtil.closeAll(bw);
	}
}
