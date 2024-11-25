package first;

import java.util.Scanner;

public class First {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		int size = input.length();
		if(size%2 == 0) {
			input = input.substring(0,size/2) + "*" + input.substring(size/2);
			size = size+1;
		}
		int mid = size/2 ;
		char arr[][] = new char[size][size];
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(i==mid) {
					arr[i][j] = input.charAt(j);
				}else if(i==j || j==mid|| j==size-i-1) {
					arr[i][j] = input.charAt(i);
				}
			}
		}
		
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
