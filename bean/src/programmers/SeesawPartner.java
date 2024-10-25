package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SeesawPartner {
	public long solution(int[] weights) {
		Map<Integer, Set<Integer>> answer = new HashMap<>();
		Map<Integer, List<Integer>> m = new HashMap<>();

		for (int weight : weights) {
			m.computeIfAbsent(weight * 2, k -> new ArrayList<>()).add(weight);
			m.computeIfAbsent(weight * 3, k -> new ArrayList<>()).add(weight);
			m.computeIfAbsent(weight * 4, k -> new ArrayList<>()).add(weight);
		}

		for (List<Integer> comb : m.values()) {
			Collections.sort(comb);
			if (comb.size() < 2) {
				continue;
			}
			for (int i = 0; i < comb.size(); i++) {
				for (int j = i + 1; j < comb.size(); j++) {
					answer.computeIfAbsent(comb.get(i), k -> new HashSet<>()).add(comb.get(j));
				}
			}
		}

		return answer.values().stream().mapToInt(s -> s.size()).sum();
	}

	public static void main(String[] args) {
		System.out.println(new SeesawPartner().solution(new int[] {100, 180, 360, 100, 270}));
	}
}
