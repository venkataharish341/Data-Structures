package ds.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagramsInString {

	public List<Integer> findAnagrams(String s, String p) {
		int l1 = p.length();
		int l2 = s.length();

		List<Integer> arr = new ArrayList<Integer>();

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for(int i=0; i<l1; i++){
			map.put(p.charAt(i), 0);
		}

		for(int i=0; i< l2-l1+1; i++){

			int count = 0;
			for(int j=0; j<l1; j++){
				if(map.containsKey(s.charAt(i+j))){
					if(map.get(s.charAt(i+j)) == 0){
						map.put(s.charAt(i+j), 1);
						count++;
					}
				}
			}

			if(count == l1){
				arr.add(i);
			}
			
			for(int j=0; j<l1; j++) {
				map.put(p.charAt(j), 0);
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		FindAnagramsInString fas = new FindAnagramsInString();
		List<Integer> arr = fas.findAnagrams("baa", "aa");
		
		for(Integer i: arr) {
			System.out.println(i);
		}
		
		
	}
}
