package ds.sorting;

public class QuickSort {


	private void sort(int[] arr, int low, int high) {
		int j = this.partition(arr, low, high);
		this.sort(arr, low, j);
		this.sort(arr, j+1, high);

	}




	private int partition(int arr[], int begin, int end) {
	    int pivot = arr[end];
	    int i = (begin-1);
	 
	    for (int j = begin; j < end; j++) {
	        if (arr[j] <= pivot) {
	            i++;
	 
	            int swapTemp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }
	 
	    int swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;
	 
	    return i+1;
	}



	public static void main(String[] args) {

		QuickSort q = new QuickSort();
		int[] arr = new int[] {6,12,3,9,10};

		q.sort(arr, 0, arr.length-1);
	}

}
