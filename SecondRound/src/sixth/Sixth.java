package sixth;

import java.util.Scanner;

public class Sixth {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String version1 = scanner.next();
		String version2 = scanner.next();
		System.out.println(checkVersion(version1,version2));
	}

	private static int checkVersion(String version1, String version2) {
		int len1 = version1.length();
		int len2 = version2.length();
		int i=0;
		int j=0;
		String str1 = "";
		String str2 = "";
		String cur1 = "";
		while(i<len1) {
			while(i<len1 && version1.charAt(i) == '0') {
				i++;
			}
			while(i<len1 && version1.charAt(i) != '.') {
				cur1 += version1.charAt(i++);
			}
			if(i<len1) str1 += (cur1.length() == 0 ? "0." : cur1+".");
			i++;
			cur1 = "";
		}
		str1 += (cur1.length() == 0 ? "0." : cur1+".");
		String cur2 = "";
		while(j<len2) {
			while(j<len2 && version2.charAt(j)=='0') {
				j++;
			}
			while(j<len2 && version2.charAt(j)!= '.') {
				cur2 += version2.charAt(j++);
			}
			if(j<len2)str2 += (cur2.length() == 0? "0." : cur2+".");
			j++;
			cur2="";
		}
		str2 += (cur2.length() == 0? "0." : cur2+".");
		
		
		System.out.println(str1 +" "+str2);
		
		i=0;
		j=0;
		while(i<str1.length() && j<str2.length()) {
			if(str1.charAt(i)==str2.charAt(j)) {
				i++;
				j++;
			}else {
				if(str1.charAt(i) == '0') return -1;
				return 1;
			}
		}
		while(i<str1.length() ) {
			if(str1.charAt(i++) == '1') return 1;
		}
		
		
		return 0;
	}
	

}
