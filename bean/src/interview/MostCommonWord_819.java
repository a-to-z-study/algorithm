package interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MostCommonWord_819 {
	public String mostCommonWord(String paragraph, String[] banned) {
		Set<String> bannedWords = Arrays.stream(banned).collect(Collectors.toSet());
		Map<String, Integer> counts = new HashMap<>();

		String[] words = paragraph.replaceAll("\\W+", " ")
			.toLowerCase()
			.split(" ");

		for (String word : words) {
			if (bannedWords.contains(word)) {
				continue;
			}

			counts.put(word, counts.getOrDefault(word, 0) + 1);
		}

		Map.Entry<String, Integer> mostWordEntry = Collections.max(
			counts.entrySet(),
			Map.Entry.comparingByValue() // (c1, c2) -> c1.getValue().compareTo(c2.getValue())
		);

		return mostWordEntry.getKey();
	}
}
