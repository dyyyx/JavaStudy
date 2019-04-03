package com.javaob.c29;

class Clerk {
	int product = 50;

	public synchronized void addProduct() {
		System.out.println("�����߿�ʼ����=====================");
		System.out.println(Thread.currentThread().getName()+"���"+product+"��");
		if(product>80) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				Thread.currentThread().sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}if(product+7>80) {
				System.out.println(Thread.currentThread().getName()+"������"+(80-product)+"��");
				product += (80-product);
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				product += 7;
				System.out.println(Thread.currentThread().getName()+"������7��");
			}
			
			notifyAll();
		}
		
	}
	public synchronized void consumeProduct() {
		System.out.println("�����߿�ʼ���ѡ���������������������������");
		System.out.println(Thread.currentThread().getName()+"���"+product+"��");
		if(product<10) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}else {
			try {
				Thread.currentThread().sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int count = (int)(10+Math.random()*20);
			if(product-count<10) {
				System.out.println(Thread.currentThread().getName()+"������"+(product-10)+"��");
				product -= (product-10);
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				product -= count;
				System.out.println(Thread.currentThread().getName()+"������"+count+"��");
			}
			
			notifyAll();
		}
	}
	public int getProduct() {
		return product;
	}

	public void setProduct(int product) {
		this.product = product;
	}

	public Clerk(int product) {
		super();
		this.product = product;
	}
	public Clerk() {
	
	}
}

class Producer implements Runnable{
	Clerk clerk;	
	
	public Producer(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		
		while(true) {
			
			clerk.addProduct();
			
		}
	}
	
}

class Consumer implements Runnable{
	Clerk clerk;
	
	public Consumer(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		
		while(true) {
			
			clerk.consumeProduct();
			
		}
	}
	
}
public class TestProducerConsumer {
	
	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		Producer p = new Producer(clerk);
		Consumer c = new Consumer(clerk);
		
		Thread t1 = new Thread(p,"������");
		Thread t2 = new Thread(c,"������");
		
		t1.start();
		t2.start();
	}
}
