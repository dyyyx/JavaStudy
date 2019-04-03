package pro;
/*
 * wait()：释放锁 sleep()：不释放锁
 * notify()/notifyAll():唤醒
 * 	与 synchronized一起使用
 */
public class Movie {
	private String pic;
	private boolean flag = true;
	//flag==T 生产者生产，消费者等待，生产完成后通知消费
	//flag==F 消费者消费，生产者等待，消费完成后通知生产
	
	public synchronized void play(String pic) {
		if(!flag) {//生产者等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//开始生产
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("生产了:"+pic);
		//生产完毕
		this.pic = pic;
		//通知消费
		this.notify();
		//生产者停止
		this.flag = false;
		
	}
	public synchronized void watch() {
		if(flag) {//消费者等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//开始消费
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//消费完毕
		System.out.println("消费了:"+pic);
		//通知生产
		this.notify();
		//消费停止
		this.flag = true;
	}
}
