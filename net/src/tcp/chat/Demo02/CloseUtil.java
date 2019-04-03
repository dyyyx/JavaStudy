package tcp.chat.Demo02;

import java.io.Closeable;

/**
 * �ر����ķ���
 * @author 979739537
 *
 */
public class CloseUtil {
	public static void closeAll(Closeable... io) {
		for(Closeable temp:io) {
			try {
				if (null != temp) {
					temp.close();
				} 
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
