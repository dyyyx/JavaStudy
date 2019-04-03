package charIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Demo01 {

	public static void main(String[] args) {
		File src = new File("D:/ѧϰ����/dyx/11/123.txt");
		Reader reader = null;
		try {
			reader = new FileReader(src);
			char[] flash = new char[10];
			int len = 0;
			while(-1!=(len=reader.read(flash))) {
				String str = new String(flash,0,len);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Դ�ļ�������");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�ļ���ȡʧ��");
		}finally {
			 try {
				if(null!=reader) {
					reader.close();
				}
			} catch (Exception e2) {
			System.out.println("�ļ��ر�ʧ��");
			}
			
		}
		
				
	}

}
