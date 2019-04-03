package pro;
/*
 * wait()���ͷ��� sleep()�����ͷ���
 * notify()/notifyAll():����
 * 	�� synchronizedһ��ʹ��
 */
public class Movie {
	private String pic;
	private boolean flag = true;
	//flag==T �����������������ߵȴ���������ɺ�֪ͨ����
	//flag==F ���������ѣ������ߵȴ���������ɺ�֪ͨ����
	
	public synchronized void play(String pic) {
		if(!flag) {//�����ߵȴ�
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//��ʼ����
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("������:"+pic);
		//�������
		this.pic = pic;
		//֪ͨ����
		this.notify();
		//������ֹͣ
		this.flag = false;
		
	}
	public synchronized void watch() {
		if(flag) {//�����ߵȴ�
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//��ʼ����
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//�������
		System.out.println("������:"+pic);
		//֪ͨ����
		this.notify();
		//����ֹͣ
		this.flag = true;
	}
}
