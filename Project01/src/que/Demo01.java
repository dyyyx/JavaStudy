package que;

import java.util.ArrayDeque;
import java.util.Queue;

public class Demo01 {
	public static void main(String[] args) {
		Queue<Request> que = new ArrayDeque<Request>();
		for(int i = 0; i < 10; i++) {
			final int num = 1;
			que.offer(new Request() {

				@Override
				public void deposit() {
					System.out.println("第"+num+"个人办理业务，存款金额为"+(Math.random()*100000));
					
				}
				
			});
		}
		dealWith(que);
	}
	public static void dealWith(Queue<Request> que) {
		Request req = null;
		while(null!=(req=que.poll())) {
			req.deposit();
		}
	}
}

interface Request{
	void deposit();
}
