package ds.sorting;

/**
 * The selection sort algorithm sorts an array by repeatedly finding the 
 * minimum element (considering ascending order) from unsorted part and putting
 * it at the beginning. The algorithm maintains two subarrays in a given array.

1) The subarray which is already sorted.
2) Remaining subarray which is unsorted.

 * In every iteration of selection sort, the minimum element (considering ascending order)
 * from the unsorted subarray is picked and moved to the sorted subarray.
 */
public class SelectionSort {

	public int[] selectSort(int[] arr){

		int min = Integer.MAX_VALUE;

		for(int j=0; j<arr.length-1; j++) {
			min = j;
			for(int i=j; i< arr.length; i++) {
				if(arr[i] <= arr[min]) {
					min = i;
				}
			}

			int temp = arr[min];
			arr[min] = arr[j];
			arr[j] = temp;
		}

		return arr;
	}

	public static void main(String[] args) {
		SelectionSort sort = new SelectionSort();
		int[] arr = sort.selectSort(new int[] {64, 25, 12, 22, 11});
		
		System.out.println(arr);
	}

}
