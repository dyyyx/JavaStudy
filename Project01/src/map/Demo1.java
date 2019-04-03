package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo1 {
	public static void main(String[] args) {
		String str = "this is a cat and that is a mice and where is the food";
		String[] strArray = str.split(" ");
		
		Map<String,Letter> letters = new HashMap<String,Letter>();
		for(String temp:strArray) {
			if(!letters.containsKey(temp)) {
				letters.put(temp, new Letter());
			}
			Letter col = letters.get(temp);
			col.setCount(col.getCount()+1);
			
		}
		Set<String> keys = letters.keySet();
		for(String key:keys) {
			Letter col = letters.get(key);
			System.out.println("×ÖÄ¸£º"+key+"£¬´ÎÊı£º"+col.getCount());
		}
	}
}
