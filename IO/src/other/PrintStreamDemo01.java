package other;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
//��ӡ�� --->�ֽ��� ������
public class PrintStreamDemo01 {
	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ps = System.out;
		ps.println(false);
		
		File src = new File("D:/ѧϰ����/dyx/11/print.txt");
		ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(src)));
		ps.println("io is so easy...");
		ps.close();
	}
}
