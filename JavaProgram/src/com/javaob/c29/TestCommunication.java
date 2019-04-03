package com.javaob.c29;

class PrintNumber implements Runnable{
	int num = 1;
	@Override
	public void run() {
		while(true) {
			synchronized (this) {
				notify();
				if (num < 100) {
					try {
						Thread.currentThread().sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + ":" + (num++));
				} else {
					break;
				}
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}

class PrintNumber1 implements Runnable{
	int num = 1;
	
	@Override
	public void run() {
		synchronized (this) {
			notify();
			while(num<=100) {
				try {
					Thread.currentThread().sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"打印"+num);
				num++;
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
	
}
public class TestCommunication {
	public static void main(String[] args) {
		PrintNumber pn = new PrintNumber();
		Thread t1 = new Thread(pn, "线程1");
		Thread t2 = new Thread(pn, "线程2");
		
		t1.start();
		t2.start();
		
	}
}
