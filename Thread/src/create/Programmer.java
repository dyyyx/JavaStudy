package create;

public class Programmer implements	Runnable {

	@Override
	public void run() {
		//线程体
		for(int i = 0; i<1000;i++) {
			System.out.println("一边敲代码.....");
		}
	}

}
