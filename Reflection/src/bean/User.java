package bean;

public class User {
	private String name;
	private int id;
	private int age;
	
	public User(String name, int id, int age) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
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
