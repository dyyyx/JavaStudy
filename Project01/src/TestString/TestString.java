package TestString;

public class TestString {
	public static void main(String[] args) {
		//String是不可变字符常量
		//StringBulider是字符变量 适用于单线程
		StringBuilder  s = new StringBuilder();  //字符数组初始长度为16
		StringBuilder  s1 = new StringBuilder(32);  //字符数组初始长度为32
	 	StringBuilder  s2 = new StringBuilder("abdc");  //字符数组初始长度为20
	 	s2.append("efg");
	 	s2.append(true).append(123).append("整数");
	 	System.out.println(s2);
	 	
	 	System.out.println("############");
	 	StringBuilder gh = new StringBuilder("a");
	 	for (int i = 0;i < 10; i++){
	 		gh.append(i);
	 	}
	 	System.out.println(gh);
	}
}
