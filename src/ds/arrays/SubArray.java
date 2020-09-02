package ds.arrays;

public class SubArray {

	public boolean subSetOrNot(int[] arr1, int[] arr2){

		int count = 0;
		
		if(arr1.length < arr2.length) {
			int[] temp = arr1;
			arr1 = arr2;
			arr2 = temp;
		}
		

		for(int i=0; i< arr2.length; i++) {
			for(int j=0; j< arr1.length; j++) {
				if(arr1[j] == arr2[i]) {
					count++;
				}
			}
		}

		if(count == arr2.length) {
			return true;
		}
		return false;

	}
	
	public boolean subSetOrNotHash(int[] arr1, int[] arr2) {
		
		
		
		
		
		return false;
	}


	public static void main(String[] args) {

		int[] arr2 = new int[] {1,5,6,3};
		int[] arr1 = new int[] {3,5,1};
		
		SubArray s = new SubArray();
		System.out.println(s.subSetOrNot(arr1, arr2));


	}

}
