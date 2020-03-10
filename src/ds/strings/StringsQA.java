package ds.strings;

import java.util.ArrayList;
import java.util.List;

public class StringsQA {

	private static int[] A = new int[4];

	public void StringCopy(char s1[], char s2[]){
		for(int i= 0; i<s1.length; i++) {
			s2[i] = s1[i];
		}
	}

	public void stringCopyReccursive(char s1[], char s2[], int i) {
		if(i == s1.length) {
			return ;
		}

		s2[i] = s1[i];
		stringCopyReccursive(s1, s2, i+1);

	}

	public void StringReversalReccursive(char s1[], char s2[], int startIndex, int endIndex) {

		if(endIndex < 0) {
			return;
		}
		s2[startIndex] = s1[endIndex];
		StringReversalReccursive(s1,s2,startIndex+1, endIndex-1);

	}

	/**
	 * Pangram means a string should have all the letters from A-Z.
	 * Example of pangram : The quick brown fox jumps over the lazy dog 
	 */
	public boolean checkPangram(String str) {
		boolean mark[] = new boolean[26];
		if(str.length() < 26) {
			return false;
		}
		int index = 0;
		for(int i=0; i< str.length(); i++) {

			if('A' <= str.charAt(i) && str.charAt(i)<= 'Z') {
				index = str.charAt(i) - 'A';
			}

			if('a' <= str.charAt(i) && str.charAt(i)<= 'z') {
				index = str.charAt(i)-'a';
			}

			mark[index] = true;
		}

		for(int j=0; j<mark.length; j++) {
			if(mark[j] == false)
				return false;
		}

		return true;
	}


	/**
	 * Generates all possible n bit k-ary strings
	 * @param n
	 * @param k
	 */
	public void generateKAryStrings(int n, int k) {
		if(n==0) {
			int h = 4;
			for(int i=0; i<h; i++) {
				System.out.print(A[i]);
			}
			System.out.println();
		}else {
			for(int j=0;j<k; j++) {
				A[n-1] = j;
				generateKAryStrings(n-1, k);
			}
		}

	}
	
	public List<Integer> checkSubstringInString(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();
		List<Integer> indexes = new ArrayList<Integer>();
		
		for(int i=0; i< l2-l1+1; i++) {
			String a = s2.substring(i, i+l1);
			
			if(a.equalsIgnoreCase(s1)) {
				indexes.add(i);
			}
		}
		
		return indexes;
	}

	public static void main(String[] args) {
		StringsQA sqa = new StringsQA();

		//sqa.generateKAryStrings(4, 2);


		/*String s = "The quick brown fox jumps over the lazy dog";
		System.out.println(sqa.checkPangram(s));*/

		/*String s1 = "Harish";
		char s2[] = new char[6];

		sqa.StringReversalReccursive(s1.toCharArray(), s2, 0, s1.length()-1);

		for(int i=0; i<s2.length;i++) {
			System.out.print(s2[i]);
		}*/
		
		List<Integer> arr = sqa.checkSubstringInString("for", "geeksforgeeksfor");
		for(Integer i: arr) {
			System.out.println(i);
		}
	}

}
