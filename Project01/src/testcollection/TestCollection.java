package testcollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class TestCollection {
	public static void main(String[] args) {
		List list = new ArrayList();
		//ArrayList:�ײ�ʵ�������顣��ѯ�죬�޸ġ����롢ɾ������
		//LinkedList:�ײ�ʵ����������ѯ�����޸ġ����롢ɾ���졣�̲߳���ȫ��Ч�ʿ졣
		//Vector:�̰߳�ȫ��Ч������
		
		list.add("aaa");
		list.add(new Date());
		list.add(1234);//�Զ�װ��
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		list.remove(new Date());
		System.out.println(list.size());
		
		List list2 = new ArrayList();
		list2.add("bbb");
		list2.add("ccc");
		list.add(list2);
		
		String str = (String)list.get(0);
		System.out.println(str);
		list.set(1, "acccs");
		list.remove(0);
		
		
	}
}
