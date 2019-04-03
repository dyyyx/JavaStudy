package create;

public class Web12306 implements Runnable {
	private int num = 50; 
	@Override
	public void run() {
		while(true) {
			if(num<1) {
				break;
				
			}
			System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
			
		}
	}
	public static void main(String[] args) {
		//创建真实角色
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
