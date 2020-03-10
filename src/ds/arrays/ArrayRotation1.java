package ds.arrays;

public class ArrayRotation1 {


	public int[] rotate(int arr[], int n){
		for(int i= 0; i<n; i++) {
			int k = arr[0];
			for(int j=0; j<arr.length; j++) {
				
				if(j != arr.length -1) {
					arr[j] = arr[j+1];
				}else {
					arr[arr.length -1] = k;
				}
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		int [] arr = {1,2,3,4,5,6,7};
		ArrayRotation1 arrR = new ArrayRotation1();
		int array[] = arrR.rotate(arr, 2);
		for(int i = 0; i< array.length; i++) {
			System.out.println(array[i]);
		}
	}

}
