package file;

import java.io.File;
import java.io.IOException;

public class Demo03 {
	public static void main(String[] args) {
		try {
			test3();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�ļ�����ʧ��");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void test3() throws IOException, InterruptedException {
		//�����ļ�
		String path = "D:/ѧϰ����/222.jpg";
		File src = new File(path);
		if(!src.exists()) {
			boolean flag = src.createNewFile();
			System.out.println(flag?"�ɹ�":"ʧ��");
		}
		//ɾ���ļ�
		boolean flag = src.delete();
		System.out.println(flag?"success":"fail");
		//������ʱ�ļ� �����˳��Զ�ɾ��
		File temp = File.createTempFile("tes", ".temp",new File("D:/ѧϰ����"));
		Thread.sleep(10000);
		temp.deleteOnExit();
	}
	public static void test2() {
		//String path = "2.txt";
		String path = "D:/ѧϰ����/1.jpg";
		File src = new File(path);
		System.out.println("�ļ��Ƿ���ڣ�"+src.exists());
		System.out.println("�ļ��Ƿ��д��"+src.canWrite());
		if(src.isFile()) {
			System.out.println("�ļ�");
		}
		else {
			//�����ڵ�Ĭ��Ϊ �ļ���
			System.out.println("�ļ���");
		}
		System.out.println("�Ƿ�Ϊ����·����"+src.isAbsolute());
		//�ֽ��� �ļ����޷���ȡ����
		System.out.println("����Ϊ��"+src.length());
	}
	public static void test1() {
		//������ϵ 
		File src = new File("D:/ѧϰ����/1.jpg");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());
	}
}
