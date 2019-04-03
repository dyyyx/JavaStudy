package syn;



public class SynDemo01 {
	public static void main(String[] args) {
		Web12306 web = new Web12306();
		//创建代理角色 Thread + 真实角色引用
		Thread t1 = new Thread(web,"路人甲");
		Thread t2 = new Thread(web,"路人乙");
		Thread t3 = new Thread(web,"路人丙");
		//启动线程
		t1.start();
		t2.start();
		t3.start();
	}
	
	
}
class Web12306 implements Runnable {
	private int num = 10; 
	private boolean flag = true;
	@Override
	public void run() {
		while(flag) {
			test02();
		}
	}
	public void test03() {
		synchronized (this) {
			if(num<1) {
				flag = false;
				return ;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
		}
		
	}
	public synchronized void test02() {
		if(num<1) {
			flag = false;
			return ;
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
	}
	
	public void test01() {
		if(num<1) {
			flag = false;
			
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
	}
}
	

