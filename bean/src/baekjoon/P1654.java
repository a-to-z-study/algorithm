package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1654 {
	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tokenizer = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(tokenizer.nextToken());
		int N = Integer.parseInt(tokenizer.nextToken());

		int[] electricWires = new int[K];

		for (int i = 0; i < K; i++) {
			electricWires[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(electricWires);


		long lt = 0;
		long rt = electricWires[electricWires.length - 1];

		if (over(electricWires, N, Integer.MAX_VALUE)) {
			System.out.println(Integer.MAX_VALUE);
			return;
		}

		int answer = 0;
		long temp = 0L;
		while (lt < rt) {
			temp = (lt + rt) / 2;

			int mid = (int) temp;

			if (mid == 0) {
				mid++;
			}

			if (over(electricWires, N, mid)) {
				answer = mid;
				lt = mid + 1;
			} else {
				rt = mid;
			}
		}

		System.out.println(answer);
	}

	private static boolean over(int[] electricWires, int n, int value) {
		int sum = 0;

		for (int electricWire : electricWires) {
			sum += electricWire / value;

			if (sum >= n) {
				return true;
			}
		}

		return false;
	}
}
