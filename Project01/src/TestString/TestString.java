package TestString;

public class TestString {
	public static void main(String[] args) {
		//String�ǲ��ɱ��ַ�����
		//StringBulider���ַ����� �����ڵ��߳�
		StringBuilder  s = new StringBuilder();  //�ַ������ʼ����Ϊ16
		StringBuilder  s1 = new StringBuilder(32);  //�ַ������ʼ����Ϊ32
	 	StringBuilder  s2 = new StringBuilder("abdc");  //�ַ������ʼ����Ϊ20
	 	s2.append("efg");
	 	s2.append(true).append(123).append("����");
	 	System.out.println(s2);
	 	
	 	System.out.println("############");
	 	StringBuilder gh = new StringBuilder("a");
	 	for (int i = 0;i < 10; i++){
	 		gh.append(i);
	 	}
	 	System.out.println(gh);
	}
}
