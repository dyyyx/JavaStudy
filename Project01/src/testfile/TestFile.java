package testfile;

import java.io.File;

public class TestFile {
	public static void main(String[] args) {
		File f = new File("d:/java学习/Project01/src/Welcome.java");
		//也可以使用于目录
		if(f.isFile()) {
			System.out.println("是一个文件");
			
		}
		if(f.isDirectory()) {
			System.out.println("是一个目录");
		}
	}
}
