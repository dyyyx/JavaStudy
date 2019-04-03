package byteIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFileDemo {
	public static void main(String[] args)  {
		String srcPath = "D:/学习工作/董羽翔/123.txt";
		String destPath = "C:/Users/97973/Desktop/1.txt";
		try {
			copyFile(srcPath,destPath);
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("关闭流失败");
		}
		
	}
	public static void copyFile(String srcPath,String destPath) throws IOException {
		File src = new File(srcPath);
		File dest = new File(destPath);
		
		//设置文件属性异常
		if(!src.isFile()) {
			System.out.println("只能拷贝文件");
			throw new IOException();
			
		}
		InputStream is = new FileInputStream(src);
		OutputStream os = new FileOutputStream(dest);
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
