package properties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Demo02 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties pro = new Properties();
		pro.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		pro.setProperty("url", "jdbc:oracle:thin:@localhost:1521:orcl");
		pro.setProperty("user", "scott");
		pro.setProperty("pwd", "123456");
		
		//¥Ê¥¢µΩæ¯∂‘¬∑æ∂e:/others/db.properties
		//pro.store(new FileOutputStream(new File("e:/others/db.properties")), "db≈‰÷√");
		//pro.storeToXML(new FileOutputStream(new File("e:/others/db.xml")), "db≈‰÷√");
		
		//¥Ê¥¢µΩœ‡∂‘¬∑æ∂
		pro.store(new FileOutputStream(new File("src/db.properties")), "db≈‰÷√");
		pro.store(new FileOutputStream(new File("src/properties/db.properties")), "db≈‰÷√");
	}
	
}
