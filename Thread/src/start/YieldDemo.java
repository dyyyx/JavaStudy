package start;

public class YieldDemo extends Thread {
	public static void main(String[] args) {
		YieldDemo demo = new YieldDemo();
		Thread t = new Thread(demo);
		t.start();
		for(int i=0;i<1000;i++) {
			if(i%20==0) {
				Thread.yield();;//ÔÝÍ£±¾Ïß³Ìmain
			}
			System.out.println("main...."+i);
		}
	}
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println("yield....."+i);
		}
	}
}
