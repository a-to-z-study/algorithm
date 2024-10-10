package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P2212 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		final PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
			return (a[1] - a[0]) - (b[1] - b[0]);
		});

		for (int i = 0; i < n - 1; i++) {
			q.offer(new int[] {arr[i], arr[i + 1]});
		}

		int len = arr[n - 1] - arr[0];
		boolean[] concentrates = new boolean[n];
		while (k < 0) {
			int[] pos = q.poll();
			if (!concentrates[pos[1]]) {
				concentrates[pos[1]] = true;
				k--;
			}

			if (!concentrates[pos[1]]) {
				concentrates[pos[1]] = true;
				k--;
			}

			len -= (pos[1] - pos[0]);
		}
	}
}
