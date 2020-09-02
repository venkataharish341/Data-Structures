package ds.recursion;

public class FibonaciMemo {

	public int fib(int n, int[] arr){
			
		int x = 0;
		int y = 0;
		
		if(n <= 2) {
			if(arr[n]!=0)
				arr[n] = n-1;
			return n-1;
		}
		
		if(arr[n-1] != 0) {
			x = arr[n-1];
		}else {
			x = fib(n-1, arr); 
		}
		if(arr[n-2] != 0) {
			y = arr[n-1];
		}else {
			y = fib(n-2, arr);
		}
		
		return x+y;
		
	}
	
	public static void main(String[] args) {
		FibonaciMemo fm = new FibonaciMemo();
		int[] arr = new int[7];
		System.out.println(fm.fib(7, arr));
	}

}
