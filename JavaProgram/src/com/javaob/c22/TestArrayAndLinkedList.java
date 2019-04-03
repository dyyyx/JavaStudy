package com.javaob.c22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TestArrayAndLinkedList {
	public static void main(String[] args) {
		List<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(1);
		al.add(4);
		al.add(0, 10);
		al.add(3, 10);
		
		System.out.println("A list of integers in the array list:");
		System.out.println(al);
		
		LinkedList<Object> ll = new LinkedList<Object>(al);
		ll.add(1, "red");
		ll.removeLast();
		ll.addFirst("green");
		
		System.out.println("Display the linked list forward:");
		ListIterator<Object> listIterator = ll.listIterator();
		while(listIterator.hasNext()) {
			System.out.print(listIterator.next() + " ");
		}
		System.out.println();
		
		System.out.println("Display the linked list backward:");
		listIterator = ll.listIterator(ll.size());
		while(listIterator.hasPrevious()) {
			System.out.print(listIterator.previous() + " ");
			
		}
	}
}
