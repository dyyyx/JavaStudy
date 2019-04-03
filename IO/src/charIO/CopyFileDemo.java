package charIO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CopyFileDemo {
	public static void main(String[] args) throws IOException {
		File src = new File("D:/学习工作/dyx/11/123.txt");
		File dest = new File("D:/学习工作/dyx/11/222.txt");
		copyFileOnlytxt(src,dest);
		
		
	}
	public static void copyFileOnlytxt(File src,File dest) throws IOException {
		Reader reader = new FileReader(src);
		Writer writer = new FileWriter(dest);
		char[] flash = new char[1024];
		int len = 0;
		
		while(-1!=(len=reader.read(flash))) {
			writer.write(flash,0,len);
		}
		
		writer.flush();
		writer.close();
		reader.close();
		
	}
}
