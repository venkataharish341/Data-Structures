package ds.sorting;

import java.util.Arrays;

public class BubbleSort {

	public void bubbleSort(int[] arr){
		int count = 0;
		do {
			count=0;
			for(int i=0; i< arr.length-1; i++) {

				if(arr[i] > arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					count++;
				}
			}
		}while(count>0);
	}

	public static void main(String[] args) {

		int[] arr = new int[] {5,1,4,2,8};
		new BubbleSort().bubbleSort(arr);
		Arrays.stream(arr).forEach(a-> System.out.println(a));

	}

}
