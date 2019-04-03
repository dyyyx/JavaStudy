package create;

public class ProgrammerApp {
	public static void main(String[] args) {
		Programmer pro = new Programmer();
		Thread proxy = new Thread(pro);
		proxy.start();
		
		for(int i = 0; i<1000;i++) {
			System.out.println("Ò»±ßÁÄÌì.....");
		}
	}
}
