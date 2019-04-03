package testdate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class VisualCalendar {
	public static void main(String[] args) {
		System.out.println("���������ڣ��磺2010-5-10����");
		Scanner scanner = new Scanner(System.in);
		
		String temp = scanner.nextLine();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d = df.parse(temp);
			Calendar c = new GregorianCalendar();
			c.setTime(d);
			int date = c.get(Calendar.DATE);
			c.set(Calendar.DATE, 1);
			int mindate = c.get(Calendar.DAY_OF_WEEK);
			int maxdate = c.getActualMaximum(Calendar.DATE);
			System.out.println(mindate);
			System.out.println("��\tһ\t��\t��\t��\t��\t��");
			for(int x=1;x<mindate;x++) {
				System.out.print("\t");
			}
			
			for(int i=1;i<=maxdate;i++) {
				if(i==date) {
					System.out.print("*");
				}
				System.out.print(i+"\t");
				
				if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY) {
					System.out.println();
				}
				c.add(Calendar.DATE,1);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
