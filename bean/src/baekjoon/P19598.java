package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.regex.Pattern;

public class P19598 {
	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
			if (a[0] == b[0]) {
				return a[1] - b[1];
			} else {
				return a[0] - b[0];
			}
		});

		PriorityQueue<int[]> rooms = new PriorityQueue<>((a, b) -> a[1] - b[1]);


		final Pattern pattern = Pattern.compile(" ");
		for (int i = 0; i < n; i++) {
			String[] input = pattern.split(br.readLine());
			int[] time = new int[2];
			time[0] = Integer.parseInt(input[0]);
			time[1] = Integer.parseInt(input[1]);
			q.offer(time);
		}

		while (!q.isEmpty()) {
			int[] time = q.poll();
			if (rooms.isEmpty() || time[0] < rooms.peek()[1]) {
				rooms.offer(time);
			}
			else {
				rooms.poll();
				rooms.offer(time);
			}
		}

		System.out.println(rooms.size());
	}
}
