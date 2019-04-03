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
		Thread t1 = new Thread(pn, "第一次输出数字");
		Thread t2 = new Thread(pn, "第二次输出数字");

		t1.start();
		t2.start();
	}
}

