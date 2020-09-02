package ds.recursion;

public class Practice {

	private int computeDifference(int[] sensA, int[] sensB, int length) {

		if(length == 0) {
			return 0;
		}

		int diff = Math.abs(sensA[length-1]) - Math.abs(sensB[length-1]);
		return diff + computeDifference(sensA, sensB, length-1);

	}

	private double sumOfSeries(int n) {

		if(n==1) {
			return 1;
		}

		double sum = Math.pow(n, n);

		return sum + sumOfSeries(n-1);

	}

	private int subArrays(int[] arr) {

		for(int s=0; s< arr.length; s++) {

			for(int e=s; e< arr.length; e++) {

				System.out.println(" ");
				for(int k=s; k<= e; k++) {

					System.out.print(arr[k] + " ");
				}
			}

		}




		return 0;
	}
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {6,4,7,2,1,9};
		
	}
}
