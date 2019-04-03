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
 * 测试脚本引擎执行javascript
 * @author 979739537
 *
 */
public class Demo01 {
	public static void main(String[] args) throws ScriptException {
		//获得脚本引擎对象
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript");
		
		//定义变量，储存到引擎的上下文
		engine.put("msg", "dyx is a good man!");
		String str = "var user = {name:'dyx',age:18,schools:['bjsxt','zjlu']};";
		str += "print(user.name);";
		
		//执行脚本
		engine.eval(str);
		engine.eval("msg = 'sxt is a good school';");
		System.out.println(engine.get("msg"));
		System.out.println("#####################");
		
		//定义函数
		engine.eval("function add(a,b){var sum = a + b; return sum}");
		//取得调用接口
		Invocable jsInvoke = (Invocable) engine;
		//执行脚本中定义的方法
		try {
			Object result1 = jsInvoke.invokeFunction("add", new Object[] {13,20});
			System.out.println(result1);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//导入其他java包，使用其他包中的java类
		String jsCode = "var list=java.util.Arrays.asList([\"bjsxt\",\"zjlu\"]);";
		engine.eval(jsCode);
		
		List<String> list2 = (List<String>)engine.get("list");
		for(String temp:list2) {
			System.out.println(temp);
		}
		
		//执行一个js文件
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
