package ds.amazon;

import java.util.HashMap;
import java.util.Map;

public class AmazonQuest {
	
	
	
	public int minPalindromeRemove(String pali) {
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i=0; i< pali.length(); i++) {
			
			if(!map.containsKey(pali.charAt(i))) {
				map.put(pali.charAt(i), 1);
			}else {
				int c = map.get(pali.charAt(i));
				map.put(pali.charAt(i), ++c);
			}
			
		}

		
		
		
		
		
		return 0;
	}

	public static void main(String[] args) {

		AmazonQuest quest = new AmazonQuest();
		quest.minPalindromeRemove("ABAABCD");
		
	}

}
