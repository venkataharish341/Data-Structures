package ds.search;

public class LinearSearch {

	public int linearSearch(int[] arr, int searchElem){
		for(int i = 0; i< arr.length; i++) {
			if(searchElem == arr[i]) {
				return i;
			}
		}
		return -1;
	}

	public int linearRecursiveSearch(int[] arr, int searchElem, int startIndex) {
		if(arr[startIndex] == searchElem) {
			return startIndex;
		}else {
			if(startIndex+1 < arr.length) {
				return linearRecursiveSearch(arr, searchElem, startIndex+1);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		LinearSearch l = new LinearSearch();
		System.out.println("Element is in index : " + l.linearSearch(arr, 4));
		
		System.out.println(l.linearRecursiveSearch(arr, 7, 0));
	}
}
