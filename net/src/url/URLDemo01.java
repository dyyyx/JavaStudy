package url;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo01 {
	public static void main(String[] args) throws MalformedURLException {
		URL url1 = new URL("http://www.baidu.com:80/index.html#aa?uname=bjsxt");
		System.out.println("Э�飺"+url1.getProtocol());
		System.out.println("������"+url1.getHost());
		System.out.println("�˿ڣ�"+url1.getPort());
		System.out.println("��Դ��"+url1.getFile());
		System.out.println("���·����"+url1.getPath());
		System.out.println("ê�㣺"+url1.getRef());
		System.out.println("������"+url1.getQuery());// ����ê�㷵��null
		
		URL url = new URL("http://www.baidu.com:80/a/");
		URL url2 = new URL(url, "b/text");
		System.out.println(url2.toString());
		
	}
}
