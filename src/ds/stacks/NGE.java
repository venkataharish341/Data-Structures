package ds.stacks;

import java.util.Arrays;
import java.util.Stack;

public class NGE {
	
	public int[] findNGE(int[] iArr){
		int[] oArr = new int[iArr.length];
		Stack<Integer> s = new Stack<Integer>();
		s.push(iArr.length-1);
		oArr[iArr.length-1] = -1;
		
		for (int i = iArr.length-2; i>=0; i--) {
			
			if(iArr[i] < iArr[s.peek()]) {
				oArr[i] = iArr[s.peek()];
			}
			
			while(!s.isEmpty() && iArr[i] > iArr[s.peek()]) {
				s.pop();
			}
			
			if(s.isEmpty()) {
				oArr[i] = -1;
			}else {
				oArr[i] = iArr[s.peek()];
			}
			
			s.push(i);
			
		}
		
		return oArr;
		
	}
	
	public static void main(String[] args) {
		NGE n = new NGE();
		int[] iArr = new int[]{13,7,6,12};
		Arrays.stream(n.findNGE(iArr)).forEach(s -> System.out.println(s));
	}

}
