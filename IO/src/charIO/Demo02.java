package charIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Demo02 {
	public static void main(String[] args) {
		File dest = new File("D:/ѧϰ����/dyx/11/123.txt");
		Writer wr = null;
		try {
			wr = new FileWriter(dest,true);
			String msq = "����������\r\n";
			wr.write(msq);
			wr.append("��ũ������");
			wr.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(null!=wr) {
					wr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
