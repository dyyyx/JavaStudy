package com.javaob.c29;

public class Bank {
	public static void main(String[] args) {
		Account1 a1 = new Account1();
		
		Thread t1 = new Thread(a1,"����1");
		Thread t2 = new Thread(a1,"����2");
		
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
			System.out.println(Thread.currentThread().getName()+"��Ǯ�ɹ�����ǰ���:"+balance);
		}
	}
}


