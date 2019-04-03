package sort;

import java.util.Arrays;

public class Demo1 {
	public static void main(String[] args) {
		String[] arr = {"a","abcd","abc","def"};
		boolean sorted = true;
		for(int j = 0;j < arr.length-1;j++) {
			sorted = true;
			for(int i = 0;i < arr.length-1-j;i++) {
				if(((Comparable)arr[i]).compareTo(arr[i+1])>0) {
					String temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					sorted = false;
				}
			}
			if(sorted) {
				break;
			}	
		}
		System.out.println(Arrays.toString(arr));
	}
}
