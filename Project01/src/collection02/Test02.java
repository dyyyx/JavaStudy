package collection02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test02 {
	public static void main(String[] args) {
		//一个Map对象对应一行记录
		Map map = new HashMap();
		map.put("id", 0301);
		map.put("name", "董羽翔");
		map.put("salary", 3000);
		map.put("department", "项目部");
		map.put("hireDate", "2018-10");
		
		Map map2 = new HashMap();
		map2.put("id", 0302);
		map2.put("name", "李四");
		map2.put("salary", 3500);
		map2.put("department", "教务部");
		map2.put("hireDate", "2017-10");
		
		Map map3 = new HashMap();
		map3.put("id", 0303);
		map3.put("name", "张三");
		map3.put("salary", 3500);
		map3.put("department", "教务部");
		map3.put("hireDate", "2016-10");
		
		List<Map> list = new ArrayList<Map>();
		list.add(map);
		list.add(map2);
		list.add(map3);
		
		printEmployeeName(list);
	}
	public static void printEmployeeName(List<Map> list) {
		for(int i = 0;i < list.size();i++) {
			Map tempMap = list.get(i);
			System.out.println(tempMap.get("name")+"--"+tempMap.get("salary"));
		}
	}
}
