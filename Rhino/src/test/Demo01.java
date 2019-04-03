package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * ���Խű�����ִ��javascript
 * @author 979739537
 *
 */
public class Demo01 {
	public static void main(String[] args) throws ScriptException {
		//��ýű��������
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript");
		
		//������������浽�����������
		engine.put("msg", "dyx is a good man!");
		String str = "var user = {name:'dyx',age:18,schools:['bjsxt','zjlu']};";
		str += "print(user.name);";
		
		//ִ�нű�
		engine.eval(str);
		engine.eval("msg = 'sxt is a good school';");
		System.out.println(engine.get("msg"));
		System.out.println("#####################");
		
		//���庯��
		engine.eval("function add(a,b){var sum = a + b; return sum}");
		//ȡ�õ��ýӿ�
		Invocable jsInvoke = (Invocable) engine;
		//ִ�нű��ж���ķ���
		try {
			Object result1 = jsInvoke.invokeFunction("add", new Object[] {13,20});
			System.out.println(result1);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//��������java����ʹ���������е�java��
		String jsCode = "var list=java.util.Arrays.asList([\"bjsxt\",\"zjlu\"]);";
		engine.eval(jsCode);
		
		List<String> list2 = (List<String>)engine.get("list");
		for(String temp:list2) {
			System.out.println(temp);
		}
		
		//ִ��һ��js�ļ�
		try {
			URL url = Demo01.class.getClassLoader().getResource("a.js");
			FileReader fr = new FileReader(url.getPath());
			engine.eval(fr);
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
