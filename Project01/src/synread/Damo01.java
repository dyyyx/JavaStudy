package synread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Damo01 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		//重新创建线程安全的list
		List<String> synList = Collections.synchronizedList(list);
		
	}

}
