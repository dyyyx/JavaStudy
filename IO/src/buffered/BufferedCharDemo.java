package buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class BufferedCharDemo {
	public static void main(String[] args) {
		File src = new File("C:/ob/c17/Ball.java");
		File dest = new File("D:/Ñ§Ï°¹¤×÷/dyx/11/3.java");
		try {
			copyFileOnlytxt(src,dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void copyFileOnlytxt(File src,File dest) throws IOException {
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		reader = new BufferedReader(new FileReader(src));
		writer = new BufferedWriter(new FileWriter(dest));
		/*
		char[] flash = new char[1024];
		int len = 0;
		
		while(-1!=(len=reader.read(flash))) {
			writer.write(flash,0,len);
		}*/
		String line = null;
		while(null != (line = reader.readLine())) {
			writer.write(line);
			writer.newLine();
		}
		writer.flush();
		writer.close();
		reader.close();
		
	}
}
