package ds.DivideAndConquer;

public class FindMinMax {

	public int[] divide(int[] arr, int start, int end, int[] result) {
		
		if(end == start) {
			result[0] = arr[start];
			result[1] = arr[start];
			return result;
		}
		
		int mid = (end+start)/2;
		
		int[] pair1 = divide(arr, start, mid, result);
		int[] pair2 = divide(arr, mid+1, end, result);
		
		if(pair1[0] < pair2[0] ) {
			result[0] = pair1[0];
		}else {
			result[0] = pair2[0];
		}
		
		if(pair1[1] > pair2[1]) {
			result[1] = pair1[1];
		}else {
			result[1] = pair2[1];
		}
		
		
		return result;
	}
	
	
	public static void main(String[] args) {
		
		FindMinMax minMax = new FindMinMax();
		int[] result = minMax.divide(new int[] {4,2,7,9,5,3}, 0, 5, new int[2]);
		System.out.println("Min : " + result[0]);
		System.out.println("Max : " + result[1]);
	}

}
