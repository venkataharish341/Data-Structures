package ds.sorting;

import java.util.PriorityQueue;

public class MergeSort {

	public int[] mergeSort(int[] arr, int start, int end) {

		if(start < end) {
			int mid = end+start/2;

			this.mergeSort(arr, start, mid);
			this.mergeSort(arr, mid+1, end);
			
			merge(arr, mid, start, end);
		}
		return arr;
	}

	private void merge(int[] arr, int mid, int start, int end) {
		
		
		
		
	}
	
	private void merge(String[] hello) {
		
		hello[0] = "Hello Man";
	}

	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		String[] arr = new String[] {"Hello", "How", "are", "u"};
		ms.merge(arr);
		System.out.println(arr[0]);
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		
	}

}
