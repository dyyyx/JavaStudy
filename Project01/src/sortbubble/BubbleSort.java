package sortbubble;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[]  arr = {9,1,2,3,4};
		sort(arr);
		System.out.println("============");
		arr = new int[] {9,1,2,3,4};
		sortFinal(arr);
		
	}
	
	public static void sortFinal(int[] arr) {
		boolean sorted = true;
		for(int j = 0;j < arr.length-1;j++) {
			sorted = true;
			System.out.println("第"+(j+1)+"趟");
			for(int i = 0;i < arr.length-1-j;i++) {
				System.out.print("第"+(i+1)+"次");
				if(arr[i]>arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					sorted = false;
					
				}
				System.out.println(Arrays.toString(arr));
			}
			if(sorted) {
				break;
			}
		}
	}
	public static void sort(int[] arr) {
		for(int j = 0;j < arr.length-1;j++) {
			System.out.println("第"+(j+1)+"趟");
			for(int i = 0;i < arr.length-1-j;i++) {
				System.out.print("第"+(i+1)+"次");
				if(arr[i]>arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
				System.out.println(Arrays.toString(arr));
			}
		}
	}
}
