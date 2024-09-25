package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2805 {
	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tokenizer = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());

		int[] trees = new int[N];

		tokenizer = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(tokenizer.nextToken());
		}

		Arrays.sort(trees);


		int lt = 0;
		int rt = trees[trees.length - 1];


		int answer = 0;
		while (lt < rt) {
			int H = (lt + rt) / 2;

			if (canCut(trees, H, M)) {
				answer = Math.max(answer, H);
				lt = H + 1;
			} else {
				rt = H;
			}
		}

		System.out.println(answer);
	}

	private static boolean canCut(int[] trees, int high, int min) {
		long sum = 0;

		for (int tree : trees) {
			int add = tree - high;
			if (add <= 0) {
				continue;
			}

			sum += add;

			if (sum >= min) {
				return true;
			}
		}

		return false;
	}
}
