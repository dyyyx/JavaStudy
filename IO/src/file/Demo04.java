package file;

import java.io.File;
import java.io.FilenameFilter;

public class Demo04 {
	public static void main(String[] args) {
		String path = "D:/学习工作/董羽翔";
		File src = new File(path);
		if(src.isDirectory()) {
			System.out.println("======子目录||文件名======");
			String[] subNames = src.list();
			for(String temp:subNames) {
				System.out.println(temp);
			}
			System.out.println("======子目录||File文件对象======");
			File[] subFile = src.listFiles();
			for(File temp:subFile) {
				System.out.println(temp.getAbsolutePath());
			}
			System.out.println("======子目录||.docx对象======");
			//命令设计模式
			subFile = src.listFiles(new FilenameFilter() {

				@Override
				//dir 代表  src
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
		String path = "D:/学习工作/parents/test.txt";
		File src = new File(path);
		//src.mkdir();
		src.mkdirs();
	}
}
