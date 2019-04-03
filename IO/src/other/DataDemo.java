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
			//write("D:/ѧϰ����/dyx/11/data.txt");
			read("D:/ѧϰ����/dyx/11/data.txt");
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
		//��ȡ˳����д��һ��   ���ڲ��ܶ�ȡ
		double num1 = dis.readDouble();
		long num2 = dis.readLong();
		String str = dis.readUTF();
		System.out.println(num2+"---->"+str);
		dis.close();
	}
	public static void write(String destPath) throws IOException {
		double point = 2.5;
		long num = 100L;
		String str = "��������";
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
