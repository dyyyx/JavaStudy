package convert;

import java.io.UnsupportedEncodingException;

public class ConvertDemo {
	public static void main(String[] args) throws UnsupportedEncodingException {
		//���� byte---->char
		String str = "�й�";
		//���� char---->byte
		byte[] data = str.getBytes();
		System.out.println(new String(data));
		data = str.getBytes("utf-8");//���ñ����ַ���
		System.out.println(new String(data));
	
	}
}
