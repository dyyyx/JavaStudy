package com.javaob.c29;

public class TestDeadLock {
	private static Object lockA = new Object();
	private static Object lockB = new Object();
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				System.out.println(Thread.currentThread().getName()+"��ʼִ����");
				synchronized (lockA) {
					System.out.println(Thread.currentThread().getName()+"�õ���lockA��");
					//��ͨ�����������߳�˯0.01�룬����һ���߳��õ�lockB��
					try {
						Thread.currentThread().sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized(lockB) {
						System.out.println(Thread.currentThread().getName()+"�õ���lockB��");
					}
				}
			}
		}.start();
		
		
		new Thread() {
			public void run() {
				System.out.println(Thread.currentThread().getName()+"��ʼִ����");
				synchronized (lockB) {
					System.out.println(Thread.currentThread().getName()+"�õ���lockB��");
					//��ͨ�����������߳�˯0.01�룬����һ���߳��õ�lockA��
					try {
						Thread.currentThread().sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized(lockA) {
						System.out.println(Thread.currentThread().getName()+"�õ���lockA��");
					}
				}
			}
		}.start();
	}
}
