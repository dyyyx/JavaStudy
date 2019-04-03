package other;

public class Employee implements java.io.Serializable{
	//transient 标识无序列化属性
	private transient String name;
	private int salary;
	public Employee() {
	}
	public Employee(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
