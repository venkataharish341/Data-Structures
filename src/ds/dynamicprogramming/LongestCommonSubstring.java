package ds.dynamicprogramming;

public class LongestCommonSubstring {

	public int findingLongestSubstring(char[] a, char[] b) {

		int[][] arr = new int[a.length+1][b.length+1];

		int max = 0;

		for(int i=0; i< a.length; i++) {
			for(int j=0; j< b.length; j++) {
				if(a[i] == b[j]) {
					arr[i+1][j+1] = arr[i][j]+1;
				}else {
					arr[i+1][j+1] = 0;
				}

				if(arr[i+1][j+1] > max) {
					max = arr[i+1][j+1];
				}

			}
		}
		return max;

	}

	public static void main(String[] args) {

		String s1 = "this is hai";
		String s2 = "hi";
		
		System.out.println(new LongestCommonSubstring().findingLongestSubstring(s1.toCharArray(), s2.toCharArray()));

	}

}
