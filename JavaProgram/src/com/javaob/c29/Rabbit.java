package com.javaob.c29;

public class Rabbit extends Thread{
	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.println("�������ˣ�"+ i +"��");
		}
	}
}

class Tortorise extends Thread{
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.println("�ڹ����ˣ�"+ i +"��");
		}
	}
}
