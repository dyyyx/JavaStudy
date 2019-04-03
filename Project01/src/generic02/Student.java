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
		//使用时指定类型（引用类型），不能使用基本类型
		//泛型声明时字母不能使用静态属性和静态方法上
		Student<String,Integer> stu = new Student<String,Integer>();
		stu.setJavaScore("优秀");
		int i = stu.getOracleScore();//自动拆箱
		}
}
