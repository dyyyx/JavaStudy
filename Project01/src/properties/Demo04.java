package properties;

import java.io.IOException;
import java.util.Properties;

public class Demo04 {

	public static void main(String[] args) throws IOException {
		Properties pro = new Properties();
		//�����·�� /��ʾbin
		//pro.load(Demo04.class.getResourceAsStream("/properties/db.properties"));
		// "" ��ʾbin
		pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("properties/db.properties"));
		System.out.println(pro.getProperty("user","dyx"));

	}

}
