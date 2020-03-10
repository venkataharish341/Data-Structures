package ds.dynamicprogramming;

public class LongestCommonSubsequence {

	public int findLongestSubsequence(char[] a, char[]b) {
		
		int[][] arr = new int[a.length+1][b.length+1];
		int max = 0;
		
		for(int i=0; i< a.length; i++) {
			
			for(int j=0; j< b.length; j++) {
				
				if(a[i] == b[j]) {
					arr[i+1][j+1] = arr[i][j]+1;
				}else {
					arr[i+1][j+1] = Math.max(arr[i+1][j], arr[i][j+1]);
				}
				if(arr[i+1][j+1] > max) {
					max = arr[i+1][j+1];
				}
			}
			
		}
		
		return max;
		
	}
	
	public static void main(String[] args) {

		char[] a = {'a','s','d','f','g','h'};
		char[] b = {'a','d','g','h','f'};
		
		System.out.println(new LongestCommonSubsequence().findLongestSubsequence(a,b));
	}

}
