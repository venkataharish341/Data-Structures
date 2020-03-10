package ds.search;

public class BinarySearch {

	public int searchAnElementRecursive(int arr[], int startIndex, int endIndex, int searchElem){
		int midIndex = startIndex + (endIndex - startIndex)/2;
		int elementIndex = -1;
		if(searchElem == arr[midIndex]) {
			return midIndex;
		}else if(searchElem < arr[midIndex]) {
			return this.searchAnElementRecursive(arr, startIndex, midIndex-1, searchElem);
		}else if(searchElem > arr[midIndex]) {
			return this.searchAnElementRecursive(arr, midIndex+1, endIndex, searchElem);
		}

		return elementIndex;
	}

	public int searchAnElement(int[] arr, int startIndex, int endIndex, int searchElem) {
		
		while(startIndex <= endIndex) {
			int midIndex = startIndex +(endIndex - startIndex)/2;
			
			
			if(searchElem < arr[midIndex]) {
				endIndex = midIndex - 1;
			}else if(searchElem > arr[midIndex]) {
				startIndex = midIndex +1;
			}else {
				return midIndex;
			}
		}
		return -1;
	}


	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5};
		System.out.println(new BinarySearch().searchAnElementRecursive(arr, 0, 4, 5));
		System.out.println(new BinarySearch().searchAnElement(arr, 0, 4, 4));


	}

}
