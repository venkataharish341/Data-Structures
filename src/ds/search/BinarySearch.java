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

	
	private char singleCharRecursion(char[] arr, int startPos, int endPos){
		
		if((endPos-startPos)%2 == 1) {
			return '1';
		}
		
		int midPos;
		while (startPos < endPos) {
			midPos = startPos + (endPos- startPos)/2;
			
			if(arr[midPos + 1] == arr[midPos]) {
				startPos = midPos;
				return singleCharRecursion(arr, startPos, endPos);
			}else if(arr[midPos - 1] == arr[midPos]) {
				endPos = midPos;
				return singleCharRecursion(arr, startPos, endPos);
			}else {
				return arr[midPos];
			}
			
		}
		return '1';
	}

	public static void main(String[] args) {
		char arr[] = null; //'a','a','b','b','c','c','d', 'd','e','e'
		System.out.println(new BinarySearch().singleCharRecursion(arr, 0, 0));
		
		/*System.out.println(new BinarySearch().searchAnElementRecursive(arr, 0, 4, 5));
		System.out.println(new BinarySearch().searchAnElement(arr, 0, 4, 4));*/
		
		

	}

}
