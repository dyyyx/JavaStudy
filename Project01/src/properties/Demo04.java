package properties;

import java.io.IOException;
import java.util.Properties;

public class Demo04 {

	public static void main(String[] args) throws IOException {
		Properties pro = new Properties();
		//类相对路径 /表示bin
		//pro.load(Demo04.class.getResourceAsStream("/properties/db.properties"));
		// "" 表示bin
		pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("properties/db.properties"));
		System.out.println(pro.getProperty("user","dyx"));

	}

}
