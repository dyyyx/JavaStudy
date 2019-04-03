package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Demo01 {
	public static void main(String[] args) throws IOException {
		
		//ͨ��IO�����������ַ��������һ����ʱ�ļ���Ȼ����ö�̬���뷽����
		String str = "public class Hi {public static void main(String[] args){System.out.println(\"Hi!\");}}";
		File dest = new File("D:/Java/Hi.java");
		BufferedWriter fw = null;
		try {
			fw = new BufferedWriter(new FileWriter(dest));
			fw.write(str);
			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(null!=fw) {
					fw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
						
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int result = compiler.run(null, null, null, "D:/Java/HelloWorld.java");
		System.out.println(result==0?"����ɹ�":"����ʧ��");
		int result2 = compiler.run(null, null, null, "D:/Java/Hi.java");
		System.out.println(result==0?"����ɹ�":"����ʧ��");
	
		/*
		//ͨ��Runtime.getRuntime()���У������µĽ��̣�
		Runtime run = Runtime.getRuntime();
		Process process = run.exec("java -cp D:/Java Hi");
		InputStream in = process.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String info = "";
		while((info=reader.readLine())!=null) {
			System.out.println(info);
		*/
		
		try {
			URL[] urls = new URL[] {new URL("file:/"+"D:/Java/")};
			URLClassLoader loader = new URLClassLoader(urls);
			Class c = loader.loadClass("HelloWorld");
			//���ü������main����
			Method m = c.getMethod("main", String[].class);
			m.invoke(null, (Object)new String[]{});
			//main��������Ҫʵ�Σ���Ҫ����(Object)ת��
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}
}
