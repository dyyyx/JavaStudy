package byteIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Demo01 {
	public static void main(String[] args) {
		//1.������ϵ File����
		File src = new File("D:/ѧϰ����/������/123.txt");
		//2.ѡ����
		InputStream is = null;//���������
		try {
			is = new FileInputStream(src);
			//3.���϶�ȡ ��������
			byte[] car = new byte[10];
			int len = 0;
			while(-1!=(len=is.read(car))) {
				String info = new String(car,0,len);
				System.out.println(info);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("�ļ�������");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("��ȡ�ļ�ʧ��");
		}finally {
			//�ͷ���Դ
		
			try {	
				if(null!=is) {
					is.close();
				}
			} catch (Exception e2) {
					
				System.out.println("�ر��ļ�������ʧ��");
			}
		}
	}
}