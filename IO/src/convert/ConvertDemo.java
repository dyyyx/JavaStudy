package convert;

import java.io.UnsupportedEncodingException;

public class ConvertDemo {
	public static void main(String[] args) throws UnsupportedEncodingException {
		//解码 byte---->char
		String str = "中国";
		//编码 char---->byte
		byte[] data = str.getBytes();
		System.out.println(new String(data));
		data = str.getBytes("utf-8");//设置编码字符集
		System.out.println(new String(data));
	
	}
}
