package byteIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Demo02 {
	public static void main(String[] args) {
		File dest = new File("D:/ѧϰ����/������/123.txt");
		OutputStream os = null;
		try {
			//true ׷��   false ����
			os = new FileOutputStream(dest,true);
			//�ַ�ת�ֽ�
			String str = "˭֮���в�\r\n";
			byte[] data = str.getBytes();
			os.write(data, 0, data.length);
			//ǿ��ˢ�����
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("�ļ�δ�ҵ�");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�ļ�д��ʧ��");
		}finally {
			try {
				if(null!=os) {
					os.close();
				}
			}catch(Exception e2) {
				System.out.println("�ر������ʧ��");
			}
			
		}
	}
}
