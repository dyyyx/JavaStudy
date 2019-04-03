package TestWrappeddass;

public class Test01 {
	public static void main(String[] args) {
		Integer a = 1000;
		Integer b = 2000;
		
		//int c = new Integer(1500);
		int c = b ;
		System.out.println(c);
		
		Integer d = 123;//[-128,127]之间的数仍当作基本数据来处理
		Integer d1 = 123;
		System.out.println(d==d1);
		System.out.println(d.equals(d1));
		
		Integer d2 = 1234;
		Integer d3 = 1234;
		System.out.println(d2==d3);
		System.out.println(d2.equals(d3));
	}
}
