package info;

public class InfoDemo02 {
	public static void main(String[] args) throws InterruptedException {
		MyThread it1 = new MyThread();
		Thread t1 = new Thread(it1,"it1");
		MyThread it2 = new MyThread();
		Thread t2 = new Thread(it2,"it2");
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
		Thread.sleep(100);
		it1.stop();
		it2.stop();
	}
}
