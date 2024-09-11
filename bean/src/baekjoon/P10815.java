package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10815 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] cards = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(cards);

		br.readLine();
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		while (st.hasMoreTokens()) {
			int nextNum = Integer.parseInt(st.nextToken());
			boolean exists = binarySearch(cards, nextNum);

			if (exists) {
				sb.append("1 ");
			} else {
				sb.append("0 ");
			}
		}

		sb.deleteCharAt(sb.length() - 1);

		System.out.println(sb);
	}

	private static boolean binarySearch(int[] cards, int num) {
		int lt = 0;
		int rt = cards.length - 1;

		while (lt < rt) {
			if (cards[lt] == num || cards[rt] == num) {
				return true;
			}

			int mid = (lt + rt) / 2;

			if (num < cards[mid]) {
				rt = mid - 1;
			} else if (num > cards[mid]) {
				lt = mid + 1;
			} else {
				return true;
			}
		}

		return false;
	}
}
