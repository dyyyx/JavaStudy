package synread;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Demo02 {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("dyx", "dyx");
		map.put("aaa", "aaa");

		//ֻ������
		Map<String,String> synMap = Collections.unmodifiableMap(map);
		//synMap.put("555", "555");
		System.out.println(synMap.size());
		
		//ֻ��һ��Ԫ�ص�����
		List<String> list = Collections.singletonList(new String());
		list.add("test");
		//list.add("dyx");
		
	}
	public static Set<String> oper(Set<String> set){
		if(null== set) {
			return Collections.emptySet();//�ⲿ��ȡ����NullPointException
		}
		return set;
		
	}
}
