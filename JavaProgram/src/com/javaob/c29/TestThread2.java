package com.javaob.c29;

class PrintNum implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<=100; i++) {
			System.out.println(Thread.currentThread().getName() + "--->" + i);
		}
	}
	
}
public class TestThread2 {
	public static void main(String[] args) {
		PrintNum pn = new PrintNum();
		Thread t1 = new Thread(pn, "��һ���������");
		Thread t2 = new Thread(pn, "�ڶ����������");

		t1.start();
		t2.start();
	}
}

