package generic02;

public class Student<T1,T2> {
	private T1 javaScore;
	private T2 oracleScore;
	
	public T1 getJavaScore() {
		return javaScore;
	}

	public void setJavaScore(T1 javaScore) {
		this.javaScore = javaScore;
	}

	public T2 getOracleScore() {
		return oracleScore;
	}

	public void setOracleScore(T2 oracleScore) {
		this.oracleScore = oracleScore;
	}

	public static void main(String[] args) {
		//ʹ��ʱָ�����ͣ��������ͣ�������ʹ�û�������
		//��������ʱ��ĸ����ʹ�þ�̬���Ժ;�̬������
		Student<String,Integer> stu = new Student<String,Integer>();
		stu.setJavaScore("����");
		int i = stu.getOracleScore();//�Զ�����
		}
}
