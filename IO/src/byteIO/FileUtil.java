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
		//设置文件属性异常
		if(!src.isFile()) {
			System.out.println("只能拷贝文件");
			throw new IOException("只能拷贝文件");
		}
		if(dest.isDirectory()) {
			System.out.println("不能建立与文件夹同名的文件");
			throw new IOException("不能建立与文件夹同名的文件");
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
