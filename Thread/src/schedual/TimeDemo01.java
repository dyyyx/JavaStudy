package schedual;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimeDemo01 {
	public static void main(String[] args) {
		Timer t = new Timer();
		t.schedule(new TimerTask() {

			@Override
			public void run() {
				System.out.println("so easy...");
			}}, new Date(System.currentTimeMillis()+1000), 200);
	}
	
}
