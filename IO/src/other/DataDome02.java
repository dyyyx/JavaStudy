package other;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataDome02 {
	public static void main(String[] args) {
		try {
			byte[] data = write();
			read(data);
			//read("D:/ѧϰ����/dyx/11/data.txt");
			System.out.println(data.length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void read(byte[] src) throws IOException {
		
		DataInputStream dis = new DataInputStream(
				new BufferedInputStream(
						new ByteArrayInputStream(src)));
		//��ȡ˳����д��һ��   ���ڲ��ܶ�ȡ
		double num1 = dis.readDouble();
		long num2 = dis.readLong();
		String str = dis.readUTF();
		dis.close();
		System.out.println(num2+"---->"+str);
		
	}
	public static byte[] write() throws IOException {
		double point = 2.5;
		long num = 100L;
		String str = "��������";
		byte[] dest = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(
				bos)
				);
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);
		dos.flush();
		dest = bos.toByteArray();
		dos.close();
		return dest;
	}
}
