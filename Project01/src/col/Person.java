package col;

public class Person {
	private final String name;
	private final int handsome;
	public Person() {
		name = null;
		handsome = 0;
	}
	public Person(String name, int handsome) {
		this.name = name;
		this.handsome = handsome;
	}
	public String getName() {
		return name;
	}
	
	public int getHandsome() {
		return handsome;
	}
	
	@Override
	public String toString() {
		return "ÐÕÃû" + this.name + ", Ë§Æø¶È" + this.handsome + "\n";
	}
	
	
}
