package other;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataDemo {
	public static void main(String[] args) {
		try {
			//write("D:/学习工作/dyx/11/data.txt");
			read("D:/学习工作/dyx/11/data.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void read(String srcPath) throws IOException {
		File src = new File(srcPath);
		DataInputStream dis = new DataInputStream(
				new BufferedInputStream(
						new FileInputStream(src)));
		//读取顺序与写出一致   存在才能读取
		double num1 = dis.readDouble();
		long num2 = dis.readLong();
		String str = dis.readUTF();
		System.out.println(num2+"---->"+str);
		dis.close();
	}
	public static void write(String destPath) throws IOException {
		double point = 2.5;
		long num = 100L;
		String str = "数据类型";
		File dest = new File(destPath);
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(
				new FileOutputStream(dest))
				);
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);
		dos.flush();
		dos.close();
	}
}
