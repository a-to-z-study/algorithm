package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class P19637 {
	//첫 번째 줄에는 칭호의 개수 N (1 ≤ N ≤ 105)과 칭호를 출력해야 하는 캐릭터들의 개수 M (1 ≤ M ≤ 105)이
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input1 = br.readLine().split(" ");
		int N = Integer.parseInt(input1[0]);
		int M = Integer.parseInt(input1[1]);

		Map<Integer, List<String>> titles = new HashMap<>();
		int[] combatPowers = new int[N];

		Pattern pattern = Pattern.compile(" ");

		for (int i = 0; i < N; i++) {
			String[] next = pattern.split(br.readLine());
			int compatPower = Integer.parseInt(next[1]);

			combatPowers[i] = compatPower;
			List<String> titleNames = titles.getOrDefault(compatPower, new ArrayList<>());
			titleNames.add(next[0]);
			titles.put(compatPower, titleNames);
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			int power = Integer.parseInt(br.readLine());

			sb.append(titles.get(calculatePower(combatPowers, power)).get(0)).append("\n");
		}

		sb.deleteCharAt(sb.length() - 1);

		System.out.println(sb);
	}

	private static int calculatePower(int[] combatPowers, int power) {
		int low = 0;
		int high = combatPowers.length - 1;

		while (low < high) {
			int mid = (low + high) / 2;

			if (combatPowers[mid] < power) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		return combatPowers[low];
	}
}
