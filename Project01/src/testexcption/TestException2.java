package testexcption;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestException2 {
	public static void main(String[] args) {
		FileReader reader = null;
		try {
			reader = new FileReader("d:/a.txt"); //checked!!
			char temp = (char)reader.read();
			
			System.out.println("�������ݣ�"+temp);
		}catch(FileNotFoundException e) {
			System.out.println("�ļ�û���ҵ���");
			e.printStackTrace();
		}catch(IOException e) { 
			System.out.println("��ȡ�ļ�����");
		}finally {
			System.out.println("#########");
			try {
				if(reader!=null) {
					reader.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
