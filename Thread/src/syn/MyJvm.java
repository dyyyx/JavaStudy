package syn;

public class MyJvm {
	private static MyJvm instance;
	private MyJvm() {
		
	}
	public static MyJvm getInstance() {
		if(null == instance) {
			synchronized(MyJvm.class) {
				if(null == instance) {
					instance = new MyJvm();
					
				}
			}
		}
		return instance;
	}
}
class MyJvm2 {
	private static MyJvm2 instance = new MyJvm2();
	private MyJvm2() {
		
	}
	public static MyJvm2 getInstance() {
		return instance;
	}
}

//类在使用时加载，延缓加载时机
class MyJvm3 {
	private static class JVMholder{
		private static MyJvm3 instance = new MyJvm3();
	}
	private MyJvm3() {
		
	}
	public static MyJvm3 getInstance() {
		return JVMholder.instance;
	}
}
