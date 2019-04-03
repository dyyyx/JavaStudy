package other;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteArrayDemo02 {
	public static void main(String[] args) throws IOException {
		
		byte[] data = getBytesFormFile("D:/学习工作/dyx/11/123.txt");
		System.out.println(new String(data));
		setBytesFile(data,"D:/学习工作/dyx/11/1.txt");
	}
	public static byte[] getBytesFormFile(String srcPath) throws IOException {
		File src = new File(srcPath);
		byte[] dest = null;
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		byte[] flash = new byte[1024];
		int len = 0;
		while(-1!=(len = is.read(flash))) {
			bos.write(flash,0,len);
		}
		bos.flush();
		dest = bos.toByteArray();
		bos.close();
		is.close();
		return dest;
	}
	public static void setBytesFile(byte[] src, String destPath) throws IOException {
		File dest = new File(destPath);
		InputStream is = new BufferedInputStream(
				new ByteArrayInputStream(src)
				);
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
		byte[] flash = new byte[1024];
		int len  = 0;
		while(-1!=(len=is.read(flash))) {
			os.write(flash, 0, len);
		}
		os.flush();
		os.close();
		is.close();
	}
}
