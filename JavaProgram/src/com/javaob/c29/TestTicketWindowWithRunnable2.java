package com.javaob.c29;


class Ticket2 implements Runnable{
	int ticket = 100;

	@Override
	public void run() {
		while(true) {
			sellTickets();
			if(ticket<=0) {
				break;
			}
		}
	}
	public synchronized void sellTickets() {
		if(ticket>0) {
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+ "售票：" +ticket--);
		}
	}
	
}
public class TestTicketWindowWithRunnable2 {
	public static void main(String[] args) {
		Ticket2 tck = new Ticket2();
		Thread t1 = new Thread(tck, "售票窗口1");
		Thread t2 = new Thread(tck, "售票窗口2");
		Thread t3 = new Thread(tck, "售票窗口3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
