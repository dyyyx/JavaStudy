package other;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class ObjectDemo01 {
	public static void main(String[] args) {
		try {
			seri("D:/学习工作/dyx/11/data1.txt");
			read("D:/学习工作/dyx/11/data1.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//反序列化
	public static void read(String srcPath) throws FileNotFoundException, IOException, ClassNotFoundException {
		File src = new File(srcPath);
		ObjectInputStream dis = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(src)));
		//读取顺序与写出一致   存在才能读取
		
		Object ob = dis.readObject();
		if(ob instanceof Employee) {
			Employee emp = (Employee)ob;
			System.out.println(emp.getName()+"\n"+emp.getSalary());
		}
		int[] arr = (int[])dis.readObject();
		System.out.println(Arrays.toString(arr));
		dis.close();
	}
	//序列化
	public static void seri(String destPath) throws FileNotFoundException, IOException {
		Employee emp = new Employee("dyx",5000000);
		int[] arr = {1,2,3,5,4};
		File dest = new File(destPath);
		ObjectOutputStream dos = new ObjectOutputStream(new BufferedOutputStream(
				new FileOutputStream(dest))
				);
		dos.writeObject(emp);
		dos.writeObject(arr);
		dos.flush();
		dos.close();
	}
}
