package com.javaob.c29;
/**
 * 创建线程的第一种方法：用Thread继承类来实现
 * @author 979739537
 *
 */
//创建一个Thread的子类
class SubThread extends Thread {
	
	@Override
	//重写run方法。完成该线程需要实现的功能
	public void run() {
		for(int i=0; i<100; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "----->" + i + "步");
		}
		
	}
}

public class TestThread{
	public static void main(String[] args) {
		SubThread s = new SubThread();
		s.start();
		
		for(int i=0; i<100; i++) {
			System.out.println(Thread.currentThread().getName() + "----->" + i + "步");
			//线程让步
//			if(i%10==0) {
//				Thread.currentThread().yield();
//			}
			//先运行子线程
//			if(i == 20) {
//				try {
//					s.join();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
		}
		
	}
}