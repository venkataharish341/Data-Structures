package ds;

public class Practice {

	public int[] sumOfArray(int[] arr, int[] fArr, int index) {

		if(index == 0) {
			fArr[0] = arr[0];
			return fArr;
		}else {
			
			fArr[index] = sumOfArray(arr, fArr, index-1)[index-1] + arr[index];
			return  fArr;
		}

	}

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3};
		int[] fArr = new int[arr.length];
		new Practice().sumOfArray(arr, fArr, arr.length-1);
	}


}
