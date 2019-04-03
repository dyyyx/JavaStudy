package url;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo01 {
	public static void main(String[] args) throws MalformedURLException {
		URL url1 = new URL("http://www.baidu.com:80/index.html#aa?uname=bjsxt");
		System.out.println("协议："+url1.getProtocol());
		System.out.println("域名："+url1.getHost());
		System.out.println("端口："+url1.getPort());
		System.out.println("资源："+url1.getFile());
		System.out.println("相对路径："+url1.getPath());
		System.out.println("锚点："+url1.getRef());
		System.out.println("参数："+url1.getQuery());// 存在锚点返回null
		
		URL url = new URL("http://www.baidu.com:80/a/");
		URL url2 = new URL(url, "b/text");
		System.out.println(url2.toString());
		
	}
}
