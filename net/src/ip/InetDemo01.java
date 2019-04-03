package ip;
/**
 *  û�з�װ�˿�
 */
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetDemo01 {
	public static void main(String[] args) throws UnknownHostException {
		//ʹ��getLocalHost��������InetAddress����
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());//���� �����ip��ַ
		System.out.println(addr.getHostName()); //���ؼ������
		//���������õ�InetAddress����
		addr = InetAddress.getByName("www.163.com");
		System.out.println(addr.getHostAddress());//����163��������ip:61.135.253.15
		System.out.println(addr.getHostName()); //���:www.163.com
		//����ip�õ�InetAddress����
		addr = InetAddress.getByName("61.135.253.15");
		System.out.println(addr.getHostAddress());//����163��������ip
		System.out.println(addr.getHostName());//���ip��ַ�����ڣ�����DNS�޷����������ip.
	}
}
