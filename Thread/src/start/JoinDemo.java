package start;

public class JoinDemo extends Thread {
	public static void main(String[] args) throws InterruptedException {
		JoinDemo demo = new JoinDemo();
		Thread t = new Thread(demo);
		t.start();
		for(int i=0;i<1000;i++) {
			if(50==i) {
				t.join();//main×èÈû
			}
			System.out.println("main...."+i);
		}
	}
	@Override
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println("join....."+i);
		}
	}
}
