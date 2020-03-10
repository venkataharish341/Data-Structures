package ds.arrays;

public class ArrayRotation2 {

	public int[] reverseArray(int arr[], int start, int end){
		int temp;
		while(start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		return arr;
	}

	private int[] leftRotate(int[] arr, int d) {
		int length = arr.length;
		this.reverseArray(arr, 0, d-1);
		this.reverseArray(arr, d, length-1);
		this.reverseArray(arr, 0, length-1);
		return arr;
	}
	
	private int[] rightRotate(int[] arr, int d) {
		int length =arr.length;
		this.reverseArray(arr, 0, length-1-d);
		this.reverseArray(arr, length-d, length-1);
		this.reverseArray(arr, 0, length-1);

		return arr;
	}

	public void printArray(int[] arr){
		for(int i = 0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8};
		ArrayRotation2 arrRotate = new ArrayRotation2();
		arrRotate.printArray(arrRotate.leftRotate(arr, 2));
		arrRotate.printArray(arrRotate.rightRotate(arr, 2));
		
	}

}
