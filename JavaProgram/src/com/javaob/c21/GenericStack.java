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
		stack1.push("北京");
		stack1.push("纽约");
		stack1.push("上海");
		System.out.println("栈中有"+stack1.getSize()+"个元素，其中栈顶元素是:"+stack1.peek());
		stack1.pop();
		GenericStack<Integer> stack2 = new GenericStack<Integer>();
		stack2.push(1);
		stack2.push(2);
		stack2.push(3);
		System.out.println("栈中有"+stack2.getSize()+"个元素，其中栈顶元素是:"+stack2.peek());
		stack2.pop();
	}
}
