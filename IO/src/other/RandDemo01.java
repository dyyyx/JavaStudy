package other;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandDemo01 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile rnd = new RandomAccessFile(new File("D:/Ñ§Ï°¹¤×÷/dyx/11/3.java"), "r");
		rnd.seek(100);
		
		byte[] flush = new byte[1024];
		int len = 0;
		
		while(-1!=(len=rnd.read(flush))) {
			if(len>=200) {
				System.out.println(new String(flush,0,200));
				break;
			}else {
				System.out.println(new String(flush,0,len));
			}
		}
		rnd.close();
	}
}		
