package fifth;

import java.util.Arrays;
import java.util.Scanner;

public class Fifth {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Number Elemets : ");
		int n = scanner.nextInt();
		System.out.print("Enter Elements : ");
		int arr[]= new int[n];
		for(int i=0;i<n;i++) {
				arr[i] = scanner.nextInt();
		}
		int res[] = new int[n];
		for(int i=0;i<n;i++) {
			int min = Integer.MAX_VALUE;
			for(int j=0;j<n;j++) {
				if(arr[i] < arr[j] && arr[j] < min) {
					min = arr[j];
				}
			}
			res[i] = min == Integer.MAX_VALUE? -1 : min;
		}
		
		System.out.println(Arrays.toString(res));
	}
}
