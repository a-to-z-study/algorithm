package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Calendar {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(reader.readLine());
		List<List<Integer>> schedules = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int firstDay = Integer.parseInt(tokenizer.nextToken());
			int lastDay = Integer.parseInt(tokenizer.nextToken());
			schedules.add(List.of(firstDay, lastDay));
		}
		schedules.sort(Comparator.comparingInt(schedule -> schedule.get(0)));

		Map<Integer, Set<Integer>> check = new HashMap<>();
		for (List<Integer> schedule : schedules) {
			int firstDay = schedule.get(0);
			int lastDay = schedule.get(1);
			if (!check.containsKey(firstDay)) {
				for (int i = firstDay; i <= lastDay ; i++) {
					check.put(i, new HashSet<>(List.of(1)));
				}
				continue;
			}

			for (int i = 1; i <= N; i++) {
				if (!check.get(firstDay).contains(i)) {
					for (int j = firstDay; j <= lastDay ; j++) {
						if (!check.containsKey(j)) {
							check.put(j, new HashSet<>(List.of(i)));
							continue;
						}
						check.get(j).add(i);
					}
					break;
				}
			}
		}

		int answer = 0;
		int widthStart = 0;
		int widthEnd = 0;
		int tempHeight = 0;

		for (int i = 1; i <= 365; i++) {
			if (check.containsKey(i) && !check.get(i).isEmpty()) {
				if (widthStart == 0) {
					widthStart = i;
				}
				widthEnd = i;
				tempHeight = Math.max(tempHeight, check.get(i).stream().max(Comparator.comparingInt(Integer::intValue)).get());
			} else {
				if (widthStart != 0) {
					answer += (widthEnd - widthStart + 1) * tempHeight;
					widthStart = 0;
					widthEnd = 0;
					tempHeight = 0;
				}
			}
		}

		if (widthStart != 0) {
			answer += (widthEnd - widthStart + 1) * tempHeight;
		}

		System.out.println(answer);
	}
}
