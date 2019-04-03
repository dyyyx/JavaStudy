package com.javaob.c21;

import java.util.ArrayList;

public class GenericStack<E> {
	private ArrayList<E> list = new ArrayList<E>();
	
	public GenericStack() {
		
	}
	
	public int getSize() {
		return list.size();
	}
	
	public E peek() {
		return list.get(getSize() - 1);
	}
	
	public E pop() {
		E o = list.get(getSize() - 1);
		list.remove(getSize() - 1);
		return o;
	}
	
	public void push(E o) {
		list.add(o);
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public static void main(String[] args) {
		GenericStack<String> stack1 = new GenericStack<String>();
		stack1.push("����");
		stack1.push("ŦԼ");
		stack1.push("�Ϻ�");
		System.out.println("ջ����"+stack1.getSize()+"��Ԫ�أ�����ջ��Ԫ����:"+stack1.peek());
		stack1.pop();
		GenericStack<Integer> stack2 = new GenericStack<Integer>();
		stack2.push(1);
		stack2.push(2);
		stack2.push(3);
		System.out.println("ջ����"+stack2.getSize()+"��Ԫ�أ�����ջ��Ԫ����:"+stack2.peek());
		stack2.pop();
	}
}
