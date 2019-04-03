package convert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class ConvertDemo02 {
	public static void main(String[] args) throws IOException {
		//指定解码字符集
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
								new File("C:/ob/c17/Ball.java")),"UTF-8")
				);
		BufferedWriter bw = new BufferedWriter(
				new FileWriter("D:/学习工作/dyx/11/123.txt",true)
				);
		String info = null;
		while (null!=(info=br.readLine())) {
			bw.write(info);
			bw.newLine();
			//System.out.println(info);
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
