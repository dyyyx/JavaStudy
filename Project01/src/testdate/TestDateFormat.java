package testdate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TestDateFormat {
	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("yyyy��MM��dd�� hh:mm:ss,����ĵ�wd��");
		
		Date d = new Date(123215222L);
		String str = df.format(d);
		System.out.println(str);
		System.out.println("################");
		String str2 = "1997-5-4";
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d2 = df2.parse(str2);
			System.out.println(d2);
		}catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
