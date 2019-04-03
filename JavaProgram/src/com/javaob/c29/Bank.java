package com.javaob.c29;

public class Bank {
	public static void main(String[] args) {
		Account1 a1 = new Account1();
		
		Thread t1 = new Thread(a1,"储户1");
		Thread t2 = new Thread(a1,"储户2");
		
		t1.start();
		t2.start();
	}
	
}

class Account1 implements Runnable{
	static int balance = 0;
	@Override
	public void run() {
		
		for(int i=0;i<3;i++) {
			balance += 1000;
			System.out.println(Thread.currentThread().getName()+"存钱成功！当前余额:"+balance);
		}
	}
}


