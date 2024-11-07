package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class SearchRanking {
	public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];

		Map<String, Map<String, Map<String, Map<String, List<Integer>>>>> record = new HashMap<>();

		final Pattern pattern = Pattern.compile(" ");
		for (String s : info) {
			String[] keys = pattern.split(s);

			record.computeIfAbsent(keys[0], key -> new HashMap<>())
				.computeIfAbsent(keys[1], key -> new HashMap<>())
				.computeIfAbsent(keys[2], key -> new HashMap<>())
				.computeIfAbsent(keys[3], key -> new ArrayList<>())
				.add(Integer.parseInt(keys[4]));
		}

		record.values()
			.stream()
			.flatMap(v1 -> v1.values().stream())
			.flatMap(v2 -> v2.values().stream())
			.flatMap(v3 -> v3.values().stream())
			.forEach(v4 -> v4.sort(Comparator.naturalOrder()));

		for (int i = 0; i < query.length; i++) {
			String[] keys = pattern.split(query[i]);

			answer[i] = record.entrySet().stream()
				.filter(e1 -> "-".equals(keys[0]) || e1.getKey().equals(keys[0]))
				.flatMap(e1 -> e1.getValue().entrySet().stream())
				.filter(e2 -> "-".equals(keys[2]) || e2.getKey().equals(keys[2]))
				.flatMap(e2 -> e2.getValue().entrySet().stream())
				.filter(e3 -> "-".equals(keys[4]) || e3.getKey().equals(keys[4]))
				.flatMap(e3 -> e3.getValue().entrySet().stream())
				.filter(e4 -> "-".equals(keys[6]) || e4.getKey().equals(keys[6]))
				.mapToInt(e4 -> getCountGreaterThanOrEqualTo(e4.getValue(), Integer.parseInt(keys[8])))
				.sum();
		}

		return answer;
	}

	private int getCountGreaterThanOrEqualTo(List<Integer> arr, Integer n) {
		int left = 0, right = arr.size();

		while (left < right) {
			int mid = (left + right) / 2;
			if (arr.get(mid) < n) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return right;
	}
}
