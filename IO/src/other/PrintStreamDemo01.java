package other;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
//打印流 --->字节流 处理流
public class PrintStreamDemo01 {
	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ps = System.out;
		ps.println(false);
		
		File src = new File("D:/学习工作/dyx/11/print.txt");
		ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(src)));
		ps.println("io is so easy...");
		ps.close();
	}
}
