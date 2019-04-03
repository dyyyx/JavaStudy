package byteIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Demo01 {
	public static void main(String[] args) {
		//1.建立联系 File对象
		File src = new File("D:/学习工作/董羽翔/123.txt");
		//2.选择流
		InputStream is = null;//提成作用域
		try {
			is = new FileInputStream(src);
			//3.不断读取 缓冲数组
			byte[] car = new byte[10];
			int len = 0;
			while(-1!=(len=is.read(car))) {
				String info = new String(car,0,len);
				System.out.println(info);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件不存在");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("读取文件失败");
		}finally {
			//释放资源
		
			try {	
				if(null!=is) {
					is.close();
				}
			} catch (Exception e2) {
					
				System.out.println("关闭文件输入流失败");
			}
		}
	}
}
