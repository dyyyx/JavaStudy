package array;

public class Marix {
	public static void main(String[] args) {
		int[][] a = {
				{1,3},
				{2,4},
				};
		int[][] b = {
				{3,4},
				{5,6},
				};
		int[][] c = new int[2][2];
		for(int i=0;i<c.length;i++) {
			for(int j=0;j<c[i].length;j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		
		for(int i=0;i<c.length;i++) {
			for(int j=0;j<c[i].length;j++) {
				System.out.print(c[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
