package interview.greedy;

import java.util.Arrays;

public class P455 {
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);

		int count = 0;
		int cookieIdx = 0;
		int childIdx = 0;

		while (childIdx < g.length && cookieIdx < s.length) {
			if (g[childIdx] <= s[cookieIdx]) {
				count++;
				childIdx++;
			}
			cookieIdx++;
		}

		return count;
	}
}
