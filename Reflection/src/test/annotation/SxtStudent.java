package test.annotation;

@SxtTable("tb_student")
public class SxtStudent {
	
	@SxtField(columnName="sname",type="varchar",length=10)
	private String name;
	@SxtField(columnName="id",type="int",length=10)
	private int id;
	@SxtField(columnName="age",type="int",length=3)
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
