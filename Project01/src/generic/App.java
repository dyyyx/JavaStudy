package generic;

public class App {
	public static void main(String[] args) {
		Object obj = 80;
		int score = (int)obj;//jdk1.7�Ժ�object->integer->�Զ�����
		System.out.println(score);
		
		
		
		Student stu = new Student(80,90);
		int javaseScore = (Integer)stu.getJavase();
		String oracleScore = null;
		if(stu.getOracle() instanceof String) {
			oracleScore = (String)stu.getOracle();
			
		}
		System.out.println("����Ϊ��"+javaseScore+","+oracleScore);
	}
}
