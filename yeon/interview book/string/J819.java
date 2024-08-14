package string;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class J819 {

	public String mostCommonWord(String paragraph, String[] banned) {
		Set<String> bannedSet = new HashSet<>(List.of(banned));
		Map<String, Integer> counter = new HashMap<>();
		String[] paragraphArray = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

		for (String word : paragraphArray) {
			if (!bannedSet.contains(word)) {
				counter.put(word, counter.getOrDefault(word, 0) + 1);
			}
		}

		return Collections.max(counter.entrySet(), (word1, word2) -> word1.getValue().compareTo(word2.getValue())).getKey();
	}

}
