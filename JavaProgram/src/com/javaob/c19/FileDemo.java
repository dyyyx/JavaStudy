package com.javaob.c19;

import java.io.File;

public class FileDemo {
	public static void main(String[] args) {
		File file1 = new File("C:\\ob\\helloworld.txt");
		File file2 = new File("words.txt");
		File file3 = new File("student.txt");
		File file4 = new File("C:\\ob");
		
		System.out.println("�ļ�����" + file1.getName());
		System.out.println("�ļ����·����" + file1.getPath());
		System.out.println("�ļ�����·����" + file1.getAbsolutePath());
		System.out.println("�ļ��ϼ�Ŀ¼��" + file1.getParent());
		System.out.println("�ļ�·�����ľ�����ʽ��" + file1.getAbsoluteFile());
		
		System.out.println("\n�ļ�����" + file2.getName());
		System.out.println("�ļ����·����" + file2.getPath());
		System.out.println("�ļ�����·����" + file2.getAbsolutePath());
		System.out.println("�ļ��ϼ�Ŀ¼��" + file2.getParent());
		System.out.println("�ļ�·�����ľ�����ʽ��" + file2.getAbsoluteFile());
		
		System.out.println("\n�ļ�����" + file3.getName());
		System.out.println("�ļ����·����" + file3.getPath());
		System.out.println("�ļ�����·����" + file3.getAbsolutePath());
		System.out.println("�ļ��ϼ�Ŀ¼��" + file3.getParent());
	}
}