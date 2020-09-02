package ds.arrays;

public class OddAndEven {

	public void sortArray(int[] arr, int length) {
		
		int even = 0;
		int odd = 1;
		
		while(true) {
			while(even < length && arr[even] % 2 == 0) {
				even += 2;
			}
			while(odd < length && arr[odd] % 2 != 0) {
				odd += 2;
			}

			if(even < length && odd < length && arr[even] % 2 != 0 && arr[odd] % 2 == 0) {
				int temp = arr[even];
				arr[even] = arr[odd];
				arr[odd] = temp;
			}else {
				break;
			}

		}
	}
	
	
	public static void main(String[] args) {
		int[] arr = new int[] {3,6,12,1,5,8};
		
		new OddAndEven().sortArray(arr, 6);
	}

}
