package info;

public class InfoDemo01 {
	public static void main(String[] args) throws InterruptedException {
		MyThread it = new MyThread();
		Thread t = new Thread(it,"it");
		t.setName("test");
		System.out.println(t.getName());
		System.out.println(Thread.currentThread().getName());
		t.start();
		System.out.println("×´Ì¬£º"+t.isAlive());
		Thread.sleep(200);
		it.stop();
		Thread.sleep(100);
		System.out.println("×´Ì¬£º"+t.isAlive());
	}
}
