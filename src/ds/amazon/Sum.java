package ds.amazon;

public class Sum{

	public int fibonaci(int n, int[] arr) {

		if(arr[n-1] != 0) {
			return arr[n-1];
		}else {
			int result = 0;
			
			if(n == 1 || n == 2) {
				result = n-1;
			}else {
				result = fibonaci(n-1, arr) + fibonaci(n-2, arr);
			}
			arr[n-1] = result;
			return result;
		}
	}

	public static void main(String[] args){

		Sum s = new Sum();
		System.out.println(s.fibonaci(40, new int[40]));


	}
}