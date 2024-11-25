package third;

import java.util.Scanner;

public class Third {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Number Elemets : ");
		int n = scanner.nextInt();
		System.out.print("Enter Elements : ");
		int arr[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = scanner.nextInt();
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
		
		for(int i=0;i<n;i++) {
			rev(arr,i);
		}
		
		
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void rev(int[][] arr, int i) {
		int j=0;
		int k=arr.length-1;
		while(j<k) {
			int temp = arr[i][j];
			arr[i][j] = arr[i][k];
			arr[i][k] = temp;
			j++;
			k--;
		}
		
	}

}
