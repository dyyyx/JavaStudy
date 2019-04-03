package testdate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class TestCalendar {
	public static void main(String[] args) {
		Calendar c = new GregorianCalendar();
		c.set(2018, 1, 10, 12, 32, 55);
		Date d = c.getTime();
		System.out.println(d);
		
		c.add(Calendar.YEAR, -20);
		System.out.println(c.getTime());
	}
}
