package buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedByteDemo {
	public static void main(String[] args) {
		
	}
	public static void copyFile(String srcPath,String destPath) throws IOException {
		File src = new File(srcPath);
		File dest = new File(destPath);
		
		//�����ļ������쳣
		if(!src.isFile()) {
			System.out.println("ֻ�ܿ����ļ�");
			throw new IOException();
			
		}
		//���뻺����
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
		byte[] flash = new byte[1024];
		int len = 0;
		
		while(-1!=(len=is.read(flash))) {
			os.write(flash, 0, len);
			
		}
		os.flush();
		
		os.close();
		is.close();
	}
}
