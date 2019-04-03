package other;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class SystemStreamDemo {

	public static void main(String[] args) throws FileNotFoundException {
		//test();
		//test2();
		//输入到文件
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("D:/学习工作/dyx/11/print.txt")),true));
		System.out.println("test");
		System.out.println("ccc");
		//返回控制台
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
		System.out.println("back..");
	}
	public static void test2() throws FileNotFoundException {
		//输入流
		InputStream is = System.in;
		is = new BufferedInputStream(new FileInputStream("D:/学习工作/dyx/11/print.txt"));
		Scanner sc = new Scanner(is);
		System.out.println(sc.nextLine());
	}
	public static void test() {
		//输出流 控制台输出
		System.out.println("test");
		System.err.println("err");
	}

}
