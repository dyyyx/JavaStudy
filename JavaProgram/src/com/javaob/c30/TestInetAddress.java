package com.javaob.c30;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress inet = InetAddress.getByName("www.163.com");
		System.out.println(inet);
		System.out.println(inet.getHostName());
		System.out.println(inet.getHostAddress());
		
		InetAddress inet1 = InetAddress.getLocalHost();
		System.out.println(inet1);
		System.out.println(inet1.getHostName());
		System.out.println(inet1.getHostAddress());
		

		InetAddress inet2 = InetAddress.getByName("localhost");
		System.out.println(inet2);
		System.out.println(inet2.getHostName());
		System.out.println(inet2.getHostAddress());
	}
}
