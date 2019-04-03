package generic02;

import java.io.Closeable;
import java.io.IOException;

public class TestMethod {

	public  static void main(String[] args) {
		test("a");
		
	}
	public static <T> void test(T a) {
		System.out.println(a);
		
	}
	public static <T extends Closeable> void test(T... a) {
		for(T temp:a) {
			try {
				if(temp!=null) {
				temp.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
