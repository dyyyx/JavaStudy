package testcollection;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("����", new Wife("����"));
		map.put("����",new Wife("��һ"));
		
		Wife w = (Wife)map.get("����");
		map.remove("����");
		System.out.println(w.name);
		
		
	}
}

class Wife{
	String name;
	public Wife(String name) {
		this.name = name;
	}
}