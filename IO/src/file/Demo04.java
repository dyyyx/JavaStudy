package file;

import java.io.File;
import java.io.FilenameFilter;

public class Demo04 {
	public static void main(String[] args) {
		String path = "D:/ѧϰ����/������";
		File src = new File(path);
		if(src.isDirectory()) {
			System.out.println("======��Ŀ¼||�ļ���======");
			String[] subNames = src.list();
			for(String temp:subNames) {
				System.out.println(temp);
			}
			System.out.println("======��Ŀ¼||File�ļ�����======");
			File[] subFile = src.listFiles();
			for(File temp:subFile) {
				System.out.println(temp.getAbsolutePath());
			}
			System.out.println("======��Ŀ¼||.docx����======");
			//�������ģʽ
			subFile = src.listFiles(new FilenameFilter() {

				@Override
				//dir ����  src
				public boolean accept(File dir, String name) {
					
					return new File(dir,name).isFile() && name.endsWith(".docx");
				}
				
			});
			for(File temp:subFile) {
				System.out.println(temp.getAbsolutePath());
			}
		}
	}
	public static void test1() {
		String path = "D:/ѧϰ����/parents/test.txt";
		File src = new File(path);
		//src.mkdir();
		src.mkdirs();
	}
}
