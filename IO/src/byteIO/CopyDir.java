package byteIO;

import java.io.File;
import java.io.IOException;

public class CopyDir {
	public static void main(String[] args) {
		String srcPath = "D:/学习工作/dyx";
		String destPath = "C:/Users/97973/Desktop/11";
		
		copyDir(srcPath,destPath);
	}
	
	public static void copyDir(String srcPath,String destPath) {
		File src = new File(srcPath);
		File dest = new File(destPath);;
		copyDir(src,dest);
		
	}
	
	public static void copyDir(File src,File dest) {
		if(src.isDirectory()) {
			dest = new File(dest,src.getName());
			if(dest.getAbsolutePath().contains(src.getAbsolutePath())) {
				System.out.println("父目录不能拷贝到子目录中");
				return;
			}
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
