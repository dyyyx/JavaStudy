package file;

import java.io.File;
import java.util.Arrays;

public class Demo05 {
	public static void  main(String[] args) {
		File f = new File("d:/Ñ§Ï°¹¤×÷/¶­ÓðÏè");
		printFile(f,0);
		
		File[] roots = File.listRoots();
		System.out.println(Arrays.toString(roots));
		for(File temp:roots) {
			printFile(temp,0);
		}
	}
	static void printFile(File file,int level) {
		for(int i = 0; i<level; i++) {
			System.out.print("-");
		}
		System.out.println(file.getName());
		if(file.isDirectory()) {
			File[] files = file.listFiles();
			for(File temp:files) {
				printFile(temp, level+1);
			}
		}
	}
}
