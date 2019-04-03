package properties;

import java.util.Properties;

public class Demo01 {
	public static void main(String[] args) {
		Properties pro = new Properties();
		pro.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		pro.setProperty("url", "jdbc:oracle:thin:@localhost:1521:orcl");
		pro.setProperty("user", "scott");
		pro.setProperty("pwd", "123456");
		
		String url = pro.getProperty("url","test");
		System.out.println(url);
		
	}

}
