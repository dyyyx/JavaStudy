package file;

import java.io.File;

public class Demo02 {
	public static void main(String[] args) {
		String parentPath = "D:/ѧϰ����";
		String name = "1.jpg";
		//���·��
		File src = new File(parentPath,name);
		src = new File(new File(parentPath),name);
		System.out.println(src.getName());
		System.out.println(src.getPath());
		//����·��
		src = new File("D:/ѧϰ����/1.jpg");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		//û���̷�����user.dir����
		src = new File("test.txt");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());
	}
}
