package byteIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {
	public static void copyFile(String srcPath,String destPath) throws IOException {
		copyFile(new File(srcPath),new File(destPath));
		
	}
	public static void copyFile(File src,File dest) throws IOException {
		//�����ļ������쳣
		if(!src.isFile()) {
			System.out.println("ֻ�ܿ����ļ�");
			throw new IOException("ֻ�ܿ����ļ�");
		}
		if(dest.isDirectory()) {
			System.out.println("���ܽ������ļ���ͬ�����ļ�");
			throw new IOException("���ܽ������ļ���ͬ�����ļ�");
		}
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
	public static void copyDir(String srcPath,String destPath) {
		File src = new File(srcPath);
		File dest = new File(destPath);;
		copyDir(src,dest);
		
	}
	
	public static void copyDir(File src,File dest) {
		if(src.isDirectory()) {
			dest = new File(dest,src.getName());
			
		}
		copyDirDetail(src,dest);
		
	}
	public static void copyDirDetail(File src,File dest) {
		if(src.isFile()) {
			try {
				FileUtil.copyFile(src, dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(src.isDirectory()) {
			dest.mkdir();
			for(File sub:src.listFiles()) {
				copyDirDetail(sub,new File(dest,sub.getName()));
				
			}
		}
	}
}
