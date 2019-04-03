package ip;
/**
 *  没有封装端口
 */
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetDemo01 {
	public static void main(String[] args) throws UnknownHostException {
		//使用getLocalHost方法创建InetAddress对象
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());//返回 计算机ip地址
		System.out.println(addr.getHostName()); //返回计算机名
		//根据域名得到InetAddress对象
		addr = InetAddress.getByName("www.163.com");
		System.out.println(addr.getHostAddress());//返回163服务器的ip:61.135.253.15
		System.out.println(addr.getHostName()); //输出:www.163.com
		//根据ip得到InetAddress对象
		addr = InetAddress.getByName("61.135.253.15");
		System.out.println(addr.getHostAddress());//返回163服务器的ip
		System.out.println(addr.getHostName());//如果ip地址不存在，或者DNS无法解析，输出ip.
	}
}
