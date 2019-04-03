package com.javaob.c22;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestHashSet {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("London");
		set.add("Paris");
		set.add("NewYork");
		set.add("Hangzhou");
		set.add("Shanghai");
		set.add("NewYork");
		System.out.println(set.toString());
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next().toUpperCase()+", ");
		}
	}
}
