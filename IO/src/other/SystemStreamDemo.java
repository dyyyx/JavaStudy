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
		//���뵽�ļ�
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("D:/ѧϰ����/dyx/11/print.txt")),true));
		System.out.println("test");
		System.out.println("ccc");
		//���ؿ���̨
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
		System.out.println("back..");
	}
	public static void test2() throws FileNotFoundException {
		//������
		InputStream is = System.in;
		is = new BufferedInputStream(new FileInputStream("D:/ѧϰ����/dyx/11/print.txt"));
		Scanner sc = new Scanner(is);
		System.out.println(sc.nextLine());
	}
	public static void test() {
		//����� ����̨���
		System.out.println("test");
		System.err.println("err");
	}

}
