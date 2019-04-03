package com.javaob.c22;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
	public static void main(String[] args) {
		Map<String, Integer> hm = new HashMap<String, Integer>();
		
		hm.put("Curry", 35);
		hm.put("Durant", 34);
		hm.put("Pual", 45);
		System.out.println("Display entries in HashMap");
		System.out.println(hm + "\n");
		
		Map<String, Integer> tm = new TreeMap<String, Integer>(hm);
		System.out.println("Display entries in ascending order of key");
		System.out.println(tm);
		
		Map<String, Integer> lhm = new LinkedHashMap<String, Integer>(16, 0.75f, true);
		lhm.put("Curry", 35);
		lhm.put("Durant", 34);
		lhm.put("Pual", 45);
		
		System.out.println("The score for" + "Durant is " + lhm.get("Durant").intValue());
		
		System.out.println("\nDisplay entries in LinkedHashMap");
		System.out.println(lhm);
	}
}
