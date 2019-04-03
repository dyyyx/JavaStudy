package file;

import java.io.File;
import java.io.IOException;

public class Demo03 {
	public static void main(String[] args) {
		try {
			test3();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件操作失败");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void test3() throws IOException, InterruptedException {
		//创建文件
		String path = "D:/学习工作/222.jpg";
		File src = new File(path);
		if(!src.exists()) {
			boolean flag = src.createNewFile();
			System.out.println(flag?"成功":"失败");
		}
		//删除文件
		boolean flag = src.delete();
		System.out.println(flag?"success":"fail");
		//创建临时文件 程序退出自动删除
		File temp = File.createTempFile("tes", ".temp",new File("D:/学习工作"));
		Thread.sleep(10000);
		temp.deleteOnExit();
	}
	public static void test2() {
		//String path = "2.txt";
		String path = "D:/学习工作/1.jpg";
		File src = new File(path);
		System.out.println("文件是否存在："+src.exists());
		System.out.println("文件是否可写："+src.canWrite());
		if(src.isFile()) {
			System.out.println("文件");
		}
		else {
			//不存在的默认为 文件夹
			System.out.println("文件夹");
		}
		System.out.println("是否为绝对路径："+src.isAbsolute());
		//字节数 文件夹无法读取长度
		System.out.println("长度为："+src.length());
	}
	public static void test1() {
		//建立联系 
		File src = new File("D:/学习工作/1.jpg");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());
	}
}
