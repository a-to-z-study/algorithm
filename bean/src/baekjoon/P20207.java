package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.regex.Pattern;

public class P20207 {
	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		final PriorityQueue<int[]> q = new PriorityQueue<>((a, b) ->
			(a[0] == b[0]) ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));

		final Pattern pattern = Pattern.compile(" ");

		for (int i = 0; i < n; i++) {
			String[] input = pattern.split(br.readLine());
			q.offer(new int[] {Integer.parseInt(input[0]), Integer.parseInt(input[1])});
		}

		List<int[]> calendar = new ArrayList<>();
		int endTime = 0;
		int startTime = 365;

		int anwser = 0;
		while (!q.isEmpty()) {
			int[] time = q.poll();
			boolean canAddSchedule = false;

			if (time[0] > endTime + 1) {
				anwser += ((endTime - startTime + 1) * calendar.size());
				calendar = new ArrayList<>();
				startTime = time[0];
				endTime = time[1];
			} else {
				startTime = Integer.min(startTime, time[0]);
				endTime = Integer.max(endTime, time[1]);
			}

			for (int[] schedule : calendar) {
				if (schedule[1] < time[0]) {
					canAddSchedule = true;
					schedule[1] = time[1];
					break;
				}
			}

			if (!canAddSchedule) {
				calendar.add(time);
			}
		}

		anwser += ((endTime - startTime + 1) * calendar.size());

		System.out.println(anwser);
	}
}
