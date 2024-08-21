package level1;

import java.util.HashSet;
import java.util.Set;

public class OurPassword {

	public String solution(String s, String skip, int index) {
		Set<Integer> skip_set = new HashSet<>();

		for (int i = 0; i < skip.length(); i++) {
			skip_set.add((int)skip.charAt(i));
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			int alpha = s.charAt(i);
			int passed = 0;

			while (passed < index) {
				if (alpha == (int)('z')) {
					alpha = (int)('a') - 1;
				}

				if (!skip_set.contains(alpha + 1)) {
					passed++;
				}

				alpha++;
			}

			sb.append((char)alpha);
		}

		return sb.toString();
	}

}
