package util;

import java.io.Closeable;
import java.net.ServerSocket;

/**
 * 关闭流的方法
 * @author 979739537
 *
 */
public class CloseUtil {
	public static <T extends Closeable>void closeAll(T... io) {
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
	public static void closeSocket(ServerSocket socket) {
		try {
			if (null != socket) {
				socket.close();
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
