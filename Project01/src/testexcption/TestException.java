package testexcption;

import java.util.Scanner;

public class TestException { 
	public static void main(String[] args) {
//		Computer c = null;
//		if(c!=null) {	
//		c.start();
//		}
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		System.out.println(a);
		
	}
}

class Computer{
	void start() {
		System.out.println("Æô¶¯");
	}
}