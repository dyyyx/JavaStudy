package com.javaob.c29;

public class TestDeadLock {
	private static Object lockA = new Object();
	private static Object lockB = new Object();
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				System.out.println(Thread.currentThread().getName()+"开始执行了");
				synchronized (lockA) {
					System.out.println(Thread.currentThread().getName()+"拿到了lockA锁");
					//让通过锁进来的线程睡0.01秒，让另一个线程拿到lockB锁
					try {
						Thread.currentThread().sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized(lockB) {
						System.out.println(Thread.currentThread().getName()+"拿到了lockB锁");
					}
				}
			}
		}.start();
		
		
		new Thread() {
			public void run() {
				System.out.println(Thread.currentThread().getName()+"开始执行了");
				synchronized (lockB) {
					System.out.println(Thread.currentThread().getName()+"拿到了lockB锁");
					//让通过锁进来的线程睡0.01秒，让另一个线程拿到lockA锁
					try {
						Thread.currentThread().sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized(lockA) {
						System.out.println(Thread.currentThread().getName()+"拿到了lockA锁");
					}
				}
			}
		}.start();
	}
}
