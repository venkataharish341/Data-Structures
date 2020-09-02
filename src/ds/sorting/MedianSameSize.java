package ds.sorting;

// Median of 2 sorted arrays of same size.

public class MedianSameSize {

	public int findMedian(int[] arr1, int[] arr2){

		int i =0, j=0;
		int a = arr1.length;

		int count =0;
		int[] result = new int[2*a];


		while(i< a && j < a) {

			if(arr1[i] < arr2[j]) {


				result[count] = arr1[i];
				i++;
			}else {

				result[count] = arr2[j];
				j++;
			}
			count++;
		}


		while(i<a) {
			result[count++] = arr1[i];
			i++;
		}

		while(j<a) {
			result[count++] = arr2[j];
			j++;
		}


		return (result[a-1] + result[a])/2;
	}


	public static void main(String[] args) {
		int[] arr1 = new int[] {1,2,4,9};
		int[] arr2 = new int[] {3,10,12,15};

		System.out.println(new MedianSameSize().findMedian(arr1, arr2));

	}

}
