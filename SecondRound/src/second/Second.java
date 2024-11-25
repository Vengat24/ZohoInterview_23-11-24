package second;

import java.util.Arrays;
import java.util.Scanner;

public class Second {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Number Elemets : ");
		int n = scanner.nextInt();
		int arr[] = new int[n];
		System.out.print("Enter Elements : ");
		for(int i=0;i<n;i++) {
			arr[i] = scanner.nextInt();
		}
		
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				if(arr[i]%2 == 0 && arr[j]%2 == 0) {
					if(arr[i] > arr[j]) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}else if(arr[i]%2 == 1 && arr[j]%2 == 1) {
					if(arr[i] < arr[j]) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
