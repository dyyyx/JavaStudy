package testcollection;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("张三", new Wife("李四"));
		map.put("王五",new Wife("赵一"));
		
		Wife w = (Wife)map.get("张三");
		map.remove("张三");
		System.out.println(w.name);
		
		
	}
}

class Wife{
	String name;
	public Wife(String name) {
		this.name = name;
	}
}
