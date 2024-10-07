package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Pattern;

public class B21758 {

	// 꿀 따기
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		Pattern pattern = Pattern.compile(" ");
		int[] spots = Arrays.stream(pattern.split(reader.readLine()))
			.mapToInt(Integer::parseInt)
			.toArray();

		// 누적 합 구하기
		int[] honeys = new int[spots.length];
		honeys[0] = spots[0];

		for (int i = 1; i < honeys.length; i++) {
			honeys[i] += honeys[i - 1] + spots[i];
		}

		int answer = 0;

		for (int i = 1; i < spots.length - 1; i++) {
			// 꿀통이 맨 오른쪽에 있으면서 맨 왼쪽에 벌이 있는 경우 : 나머지 벌 하나가 i
			int case_1 = honeys[honeys.length - 1] * 2 - spots[0] - spots[i] - honeys[i];
			// 꿀통이 맨 왼쪽에 있으면서 맨 오른쪽에 벌이 있는 경우 : 나머지 벌 하나가 i
			int case_2 = honeys[honeys.length - 1] - spots[spots.length - 1] - spots[i] + honeys[i - 1];
			// 꿀통이 중간 어딘가에 있으면서 양 끝에 벌이 있는 경우 : 꿀통이 i
			int case_3 = honeys[i] - spots[0] + honeys[honeys.length - 2] - honeys[i - 1];

			int temp = Math.max(case_1, case_2);
			int max = Math.max(temp, case_3);
			answer = Math.max(max, answer);
		}

		System.out.println(answer);
	}

}
