package syn;

public class SynDemo02 {
	public static void main(String[] args) {
		JvmThread thread = new JvmThread(100);
		JvmThread thread2 = new JvmThread(500);
		thread.start();
		thread2.start();
	}
}
class JvmThread extends Thread{
	private long time;
	public JvmThread() {
		
		
	}
	public JvmThread(long time) {
		this.time = time;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"-->´´½¨"+Jvm.getInstance(time));
	}
}
class Jvm{
	private static Jvm instance = null;
	private Jvm() {
		
	}
	public static Jvm getInstance(long time) {
		if(null == instance) {
			synchronized(Jvm.class){
				if(null == instance) {
					try {
						Thread.sleep(time);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					instance = new Jvm();	
				}	
			}
		} 
		return instance;
	}
	public static Jvm getInstance3(long time) {
		synchronized(Jvm.class){
			if(null == instance) {
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				instance = new Jvm();
				
			}
			return instance;
		}
	}
	public static synchronized Jvm getInstance2(long time) {
		if(null == instance) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Jvm();
			
		}
		return instance;
		
	}
	public static Jvm getInstance1(long time) {
		if(null == instance) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Jvm();
			
		}
		return instance;
		
	}
	
}
