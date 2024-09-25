package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P20437 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		final StringBuilder sb = new StringBuilder();
		while (n > 0) {
			String w = br.readLine();
			int k = Integer.parseInt(br.readLine());

			int[] result = game(w, k);

			if (result[0] == -1) {
				sb.append(-1);
			} else {
				sb.append(result[0]).append(" ").append(result[1]);
			}
			sb.append(System.lineSeparator());

			n--;
		}

		System.out.println(sb);
	}

	private static int[] game(String w, int k) {
		// 0 : 중복 개수
		// 1 : 시작 인덱스
		// 2 : 종료 인덱스

		List<Deque<Integer>> record = new ArrayList<>();

		for (int i = 0; i < 26; i++) {
			record.add(new ArrayDeque<>());
		}

		int len = w.length();

		int[] result = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};

		for (int i = 0; i < len; i++) {
			int point = w.charAt(i) - 'a';

			Deque<Integer> indexs = record.get(point);
			indexs.offerLast(i);

			if (indexs.size() == k) {
				result[0] = Math.min(result[0], indexs.peekLast() - indexs.peekFirst() + 1);
				result[1] = Math.max(result[1], indexs.peekLast() - indexs.peekFirst() + 1);

				indexs.pollFirst();
			}
		}

		if (result[0] == Integer.MAX_VALUE) {
			return new int[] {-1, -1};
		}

		return result;
	}
}
