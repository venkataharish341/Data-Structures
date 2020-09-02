package ds.greedyAlgorithm;

public class FractionalKnapsack {


	private int findMaxVal(int[] wt, int[] val, int capacity) {
		int[] perUnitValue = new int[wt.length];
		
		for(int i=0; i< wt.length; i++) {
			perUnitValue[i] = val[i]/wt[i];  
		}
		
		int totalValue = 0;
		
		while(capacity > 0) {
			int maxIndex = findMaxPerUnitValue(perUnitValue);
			
			if(wt[maxIndex] < capacity) {
				totalValue = totalValue + val[maxIndex];
				capacity -= wt[maxIndex]; 
			}else {
				totalValue += (val[maxIndex]/wt[maxIndex])*(capacity);
				capacity -= (val[maxIndex]/wt[maxIndex])*(capacity);
			}
		}
		
		return totalValue;
	}

	private int findMaxPerUnitValue(int[] perUnitValue) {
		
		int max = perUnitValue[0];
		int index = 0;
		for(int i=1; i < perUnitValue.length; i++) {
			if(perUnitValue[i] > max) {
				max = perUnitValue[i];
				index = i;
			}
		}
		
		perUnitValue[index] = 0;
		return index;
	}

	public static void main(String[] args) {
		int[] wt = {10, 40, 20, 30};
		int[] val = {60, 40, 100, 120};
		int capacity = 50; 

		FractionalKnapsack fk = new FractionalKnapsack();
		System.out.println(fk.findMaxVal(wt, val, capacity));
	}



}
