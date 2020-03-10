package ds.arrays;

public class Practice {
	
	
	public String reverseArray(String word, int initialPos, int finalPos){
		char[] arr = word.toCharArray();
		
		while(initialPos < finalPos) {
			char temp = arr[initialPos];
			arr[initialPos] = arr[finalPos];
			arr[finalPos] = temp;
			initialPos++;
			finalPos--;
		}
		return String.valueOf(arr);
	}
	
	public String reverseSentence(String sentence) {
		String[] sentenceArr = sentence.split(" ");
		StringBuilder sb = new StringBuilder();

		for(int i=0; i<sentenceArr.length; i++) {
			sb.append(this.reverseArray(sentenceArr[i], 0, sentenceArr[i].length()-1)).append(" ");
		}


		return (reverseArray(sb.toString(), 0, sb.toString().length()-1));
	}
	
	
	public String reverseSentenceRecursion(String sentence) {
		
		
		return null;
	}
	
	
	public void fizzbuzz() {
		for(int i=0; i<100; i++) {
			if(i%3==0 && i%5==0) {
				System.out.println("FizzBUZZ");
			}else if(i%3 == 0) {
				System.out.println("Fizz");
			}else if(i%5 == 0) {
				System.out.println("Buzz");
			}else {
				System.out.println(i);
			}
		}
	}
	
	public void sum(int[] arr, int sum) {
		
		
	}

	public static void main(String[] args) {
		Practice p = new Practice();
		//System.out.println(p.reverseSentenceRecursion("This is Harish"));
		p.fizzbuzz();
	}

}
