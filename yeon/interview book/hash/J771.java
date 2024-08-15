package hash;

import java.util.HashSet;
import java.util.Set;

public class J771 {

	public int numJewelsInStones(String jewels, String stones) {
		Set<Character> dictionary = new HashSet<>();
		for (char c : jewels.toCharArray()) {
			dictionary.add(c);
		}

		int count = 0;
		for (char c : stones.toCharArray()) {
			if (dictionary.contains(c)) {
				count++;
			}
		}

		return count;
	}

}
