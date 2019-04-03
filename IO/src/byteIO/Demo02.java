package byteIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Demo02 {
	public static void main(String[] args) {
		File dest = new File("D:/学习工作/董羽翔/123.txt");
		OutputStream os = null;
		try {
			//true 追加   false 覆盖
			os = new FileOutputStream(dest,true);
			//字符转字节
			String str = "谁之盘中餐\r\n";
			byte[] data = str.getBytes();
			os.write(data, 0, data.length);
			//强制刷新输出
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件未找到");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件写出失败");
		}finally {
			try {
				if(null!=os) {
					os.close();
				}
			}catch(Exception e2) {
				System.out.println("关闭输出流失败");
			}
			
		}
	}
}
