package file;

import java.io.File;

public class Demo01 {
	public static void main(String[] args) {
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		//路径表达式
		String path = "D:\\学习工作";
		//用于动态生成
		path = "D:"+File.pathSeparator+"学习工作";
		//推荐表达形式
		path = "D:/学习工作";
	}
}
