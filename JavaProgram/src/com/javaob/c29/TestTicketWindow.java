package com.javaob.c29;


class Tickets extends Thread{
	static int ticket = 100;
	@Override
	public void run() {
		while(true) {
			if(ticket>0) {
				System.out.println(Thread.currentThread().getName()+"售票："+ticket--);
			}else {
				break;
			}
		}
	}
}
public class TestTicketWindow {
	public static void main(String[] args) {
		Tickets tck1 = new Tickets();
		Tickets tck2 = new Tickets();
		Tickets tck3 = new Tickets();
		tck1.setName("售票窗口1");
		tck2.setName("售票窗口2");
		tck3.setName("售票窗口3");
		tck1.start();
		tck2.start();
		tck3.start();
	}
}
