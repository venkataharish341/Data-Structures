package ds.search;

public class RotatedSortedArr {


	public int searchElement(int[] arr){

		int n = arr.length;
		int index = this.findPivot(arr, 0 , n-1);
		




		return index;
	}

	public int findPivot(int[] arr, int start, int end){

		if(end < start) {
			return -1;
		}
		if(end == start) {
			return start; 
		}

		int mid = (start + end) /2;


		if(arr[mid] > arr[mid+1]) {
			return mid;
		}else if(arr[mid] < arr[mid-1]) {
			return mid-1;
		}else if(arr[start] > arr[mid]) {
			return findPivot(arr, start, mid);
		}
		return findPivot(arr, mid, end);


	}


	public static void main(String[] args) {
		RotatedSortedArr rArr = new RotatedSortedArr();
		int[] arr = new int[] {3,4,6,1,2};
		System.out.println(rArr.searchElement(arr));
	}

}
