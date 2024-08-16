package greedy;

import java.util.Arrays;

public class J455 {

	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);

		int greedIndex = 0;
		int cookieIndex = 0;
		int answer = 0;

		while (cookieIndex < s.length && greedIndex < g.length) {
			if (s[cookieIndex] >= g[greedIndex]) {
				answer++;
				greedIndex++;
			}

			cookieIndex++;
		}

		return answer;
	}

}
