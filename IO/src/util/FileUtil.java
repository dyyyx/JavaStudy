package util;

import java.io.Closeable;
import java.io.IOException;

public class FileUtil {
	public static void close(Closeable ... io) {
		for(Closeable temp:io) {
			if(null!=temp) {
				try {
					temp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static <T extends Closeable> void closeAll(T ... io) {
		for(Closeable temp:io) {
			if(null!=temp) {
				try {
					temp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
