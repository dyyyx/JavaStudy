package testfile;

import java.io.File;

public class TestFile {
	public static void main(String[] args) {
		File f = new File("d:/javaѧϰ/Project01/src/Welcome.java");
		//Ҳ����ʹ����Ŀ¼
		if(f.isFile()) {
			System.out.println("��һ���ļ�");
			
		}
		if(f.isDirectory()) {
			System.out.println("��һ��Ŀ¼");
		}
	}
}
