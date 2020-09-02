package ds.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

	public int numJewelsInStones(String J, String S) {

		int count = 0;
		char[] arr = J.toCharArray();

		List<Character> charList = new ArrayList<Character>();

		for(char c: arr ) {
			charList.add(c);
		}

		for(int i=0; i<S.length(); i++ ){
			if(charList.contains(S.charAt(i))){
				count++;
			}
		}
		return count;
	}

	public List<Integer> selfDividingNumbers(int left, int right) {


		List<Integer> arr = new ArrayList<Integer>();

		for(int i= left; i<= right; i++){

			int num = i;

			while(num != 0){
				int divNum = num%10;

				if(divNum == 0) {
					break;
				}
				if(i % divNum == 0){
					num = num/10;    
				}else{
					break;
				}
				if(num == 0){
					System.out.println(i);
				}

			}
		}

		return arr;
	}

	public int myAtoi(String str) {
		String b = new String();
		String result = new String();

		for(int i=0; i< str.length(); i++){
			if(str.charAt(i)== ' '){
				continue;
			}else{
				b = b + str.charAt(i);
			}
		}


		char[] arr = b.toCharArray();

		for(int j=0; j< arr.length; j++){

			if(j == 0 && (arr[j] == '-' || arr[j] == '+')){
				result+= arr[j];
				continue;
			}

			if(j == 0 && !(arr[j] >= '0' && arr[j] <= '9')){
				result = "0";
				break;
			}

			if(arr[j] >= '0' && arr[j] <= '9'){
				result += arr[j];
			}

		}

		int i = Integer.parseInt(result);
		if(i > Math.pow(2, 31)-1){
			return Integer.MAX_VALUE;
		}
		if(i < -Math.pow(2, 31)){
			return Integer.MIN_VALUE;
		}

		return i;

	}

	public boolean wordBreak(String s, List<String> wordDict) {

		int start = 0;
		int end = 0;
		Set<String> set = new HashSet<String>();

		for(int i=0; i< wordDict.size(); i++){
			set.add(wordDict.get(i));
		}


		while(start <= s.length()-1 && end <= s.length()-1){

			if(set.contains(s.substring(start,end+1))){
				start = end+1;
				end++;
				if(start > s.length()-1){
					return true;
				}

			}else{
				end++;
			}

		}
		return false;

	}

	public String sortString(String s) {

		int[] freqCount = new int[26];

		for(int i=0; i< s.length(); i++){
			freqCount[s.charAt(i)-'a']++;
		}

		StringBuilder result = new StringBuilder();
		int strLength = s.length();

		while(strLength > 0){

			for(int i=0; i< 26; i++){
				if(freqCount[i] > 0){
					result.append((char) (97+i));
					strLength--;
				}
			}

			for(int i=25; i>=0; i--){
				if(freqCount[i] > 0){
					result.append((char) (97+i));
					strLength--;
				}
			}
		}

		return result.toString();
	}

	/*public int findDuplicate(int[] nums) {
        int tortoise= 0;
        int hare= 0;
        while(true)
        {
        	tortoise = (tortoise+1)%nums.length;
        	hare = (hare+2)%nums.length;
        	
        	if(nums[tortoise] == nums[hare]) {
        		break;
        	}
        	
        }
        
        return nums[tortoise];
    }*/
	
	 public int findDuplicate(int[] nums) {
	        int tortoise=nums[0];
	        int hare=nums[0];
	        while(true)
	        {
	            tortoise=nums[tortoise];
	            hare=nums[nums[hare]];
	            if(tortoise==hare)
	                break;
	        }
	        int ptr1=nums[0];
	        int ptr2=tortoise;
	        while(ptr1!=ptr2)          
	        {
	            ptr1=nums[ptr1];
	            ptr2=nums[ptr2];
	        } 
	        return ptr1;
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

		/*List<Integer> arr = sqa.checkSubstringInString("for", "geeksforgeeksfor");
		for(Integer i: arr) {
			System.out.println(i);
		}*/

		/*String J = "aA";
		String S = "aAAbbb";

		System.out.println(sqa.numJewelsInStones(J, S));*/

		//System.out.println(sqa.myAtoi("  -42"));

		System.out.println(sqa.findDuplicate(new int[] {18,13,14,17,9,19,7,17,4,6,17,5,11,10,2,15,8,12,16,17}));


	}

}
