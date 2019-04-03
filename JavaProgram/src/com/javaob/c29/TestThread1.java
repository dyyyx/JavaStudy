package com.javaob.c29;

class PrintEven extends Thread{
	@Override
	public void run() {
		for (int i=0; i<=100; i++) {
			if(i%2 == 0) {
				System.out.println(Thread.currentThread().getName() + "----->" + i);
			}
		}
	}
}

class PrintAdd extends Thread{
	@Override
	public void run() {
		for (int i=0; i<=100; i++) {
			if(i%2 == 1) {
				System.out.println(Thread.currentThread().getName() + "----->" + i);
			}
		}
	}
}

public class TestThread1 {
	public static void main(String[] args) {
		PrintEven pe = new PrintEven();
		PrintAdd pa = new PrintAdd();
		
		new Thread() {
			public void run() {
				for (int i=0; i<=100; i++) {
					if(i%2 == 1) {
						System.out.println(Thread.currentThread().getName() + "----->" + i);
					}
				}
			}; 
		}.start();
	
		pe.setName("线程1：输出偶数");
		pa.setName("线程2：输出奇数");
		pe.start();
		pa.start();
		
		
	}
}

