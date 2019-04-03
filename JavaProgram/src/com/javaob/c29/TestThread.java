package com.javaob.c29;
/**
 * �����̵߳ĵ�һ�ַ�������Thread�̳�����ʵ��
 * @author 979739537
 *
 */
//����һ��Thread������
class SubThread extends Thread {
	
	@Override
	//��дrun��������ɸ��߳���Ҫʵ�ֵĹ���
	public void run() {
		for(int i=0; i<100; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "----->" + i + "��");
		}
		
	}
}

public class TestThread{
	public static void main(String[] args) {
		SubThread s = new SubThread();
		s.start();
		
		for(int i=0; i<100; i++) {
			System.out.println(Thread.currentThread().getName() + "----->" + i + "��");
			//�߳��ò�
//			if(i%10==0) {
//				Thread.currentThread().yield();
//			}
			//���������߳�
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