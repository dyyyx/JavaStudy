package file;

import java.io.File;

public class Demo01 {
	public static void main(String[] args) {
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		//·�����ʽ
		String path = "D:\\ѧϰ����";
		//���ڶ�̬����
		path = "D:"+File.pathSeparator+"ѧϰ����";
		//�Ƽ������ʽ
		path = "D:/ѧϰ����";
	}
}
