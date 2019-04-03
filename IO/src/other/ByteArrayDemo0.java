package other;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteArrayDemo0 {
	public static void main(String[] args) {
		try {
			read(writer());
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("读取失败");
		}
	}
	public static byte[] writer() throws IOException {
		byte[] dest;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		String msq = "操作与文件输入流操作一致";
		byte[] info = msq.getBytes();
		bos.write(info,0,info.length);
		dest = bos.toByteArray();
		bos.close();
		return dest;
	}
	public static void read(byte[] src) throws IOException {

		InputStream is = new BufferedInputStream(
				new ByteArrayInputStream(src)
				);
		byte[] flash = new byte[1024];
		int len = 0;
		while(-1!=(len=is.read(flash))) {
			System.out.println(new String(flash,0,len));
			
		}
		is.close();
		
	}
}
