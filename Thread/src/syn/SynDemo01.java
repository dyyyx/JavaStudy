package syn;



public class SynDemo01 {
	public static void main(String[] args) {
		Web12306 web = new Web12306();
		//���������ɫ Thread + ��ʵ��ɫ����
		Thread t1 = new Thread(web,"·�˼�");
		Thread t2 = new Thread(web,"·����");
		Thread t3 = new Thread(web,"·�˱�");
		//�����߳�
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
			System.out.println(Thread.currentThread().getName()+"������"+num--);
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
		System.out.println(Thread.currentThread().getName()+"������"+num--);
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
		System.out.println(Thread.currentThread().getName()+"������"+num--);
	}
}
	

