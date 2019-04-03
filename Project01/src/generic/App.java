package generic;

public class App {
	public static void main(String[] args) {
		Object obj = 80;
		int score = (int)obj;//jdk1.7以后object->integer->自动拆箱
		System.out.println(score);
		
		
		
		Student stu = new Student(80,90);
		int javaseScore = (Integer)stu.getJavase();
		String oracleScore = null;
		if(stu.getOracle() instanceof String) {
			oracleScore = (String)stu.getOracle();
			
		}
		System.out.println("分数为："+javaseScore+","+oracleScore);
	}
}
