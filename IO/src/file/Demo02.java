package file;

import java.io.File;

public class Demo02 {
	public static void main(String[] args) {
		String parentPath = "D:/学习工作";
		String name = "1.jpg";
		//相对路径
		File src = new File(parentPath,name);
		src = new File(new File(parentPath),name);
		System.out.println(src.getName());
		System.out.println(src.getPath());
		//绝对路径
		src = new File("D:/学习工作/1.jpg");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		//没有盘符：以user.dir构建
		src = new File("test.txt");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());
	}
}
