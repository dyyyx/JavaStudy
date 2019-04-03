package properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Demo03 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties pro = new Properties();
		//读取 绝对路径文件
		//pro.load(new FileReader("e:/others/db.properties"));
		//读取 相对路径文件
		pro.load(new FileReader("src/db.properties"));
		System.out.println(pro.getProperty("user","dyx"));
	}
}
