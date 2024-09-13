package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GearWheel {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		List<List<Character>> gears = new ArrayList<>();

		for (int i = 0; i < 4; i++) {
			List<Character> gear = new ArrayList<>();
			String string = reader.readLine();

			for (int j = 0; j < string.length(); j++) {
				gear.add(string.charAt(j));
			}

			gears.add(gear);
		}

		int K = Integer.parseInt(reader.readLine()); // 회전 횟수
		int LEFT = 6;
		int RIGHT = 2;
		int START = 0;
		int END = 7;

		for (int i = 0; i < K; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int gear_number = Integer.parseInt(tokenizer.nextToken()) - 1;
			int direction = Integer.parseInt(tokenizer.nextToken()); // 1: 시계 방향 // -1: 반시계 방향

			// 왼쪽에 톱니바퀴가 있다면 회전
			if (gear_number > 0) {
				List<int[]> gear_to_move = new ArrayList<>();
				int left = gear_number - 1;
				int current_direction = direction;

				while (left >= 0) {
					List<Character> current_gear = gears.get(left + 1);
					List<Character> left_gear = gears.get(left);
					boolean movable = current_gear.get(LEFT) != left_gear.get(RIGHT);

					if (!movable)
						break;

					current_direction *= -1;
					gear_to_move.add(new int[]{left, current_direction}); // { 톱니바퀴, 회전 방향 }
					left--;
				}

				for (int[] gear : gear_to_move) {
					List<Character> current_gear = gears.get(gear[0]);

					if (gear[1] == 1) {
						current_gear.add(START, current_gear.remove(END));
					} else {
						current_gear.add(current_gear.remove(START));
					}
				}
			}

			// 오른쪽에 톱니바퀴가 있다면 회전
			if (gear_number < 3) {
				List<int[]> gear_to_move = new ArrayList<>();
				int right = gear_number + 1;
				int current_direction = direction;

				while (right < 4) {
					List<Character> current_gear = gears.get(right - 1);
					List<Character> right_gear = gears.get(right);
					boolean movable = current_gear.get(RIGHT) != right_gear.get(LEFT);

					if (!movable)
						break;

					current_direction *= -1;
					gear_to_move.add(new int[]{right, current_direction});
					right++;
				}

				for (int[] gear : gear_to_move) {
					List<Character> current_gear = gears.get(gear[0]);

					if (gear[1] == 1) {
						current_gear.add(START, current_gear.remove(END));
					} else {
						current_gear.add(current_gear.remove(START));
					}
				}
			}

			// 자신의 톱니바퀴 회전
			List<Character> current_gear = gears.get(gear_number);

			if (direction == 1) {
				current_gear.add(START, current_gear.remove(END));
			} else {
				current_gear.add(current_gear.remove(START));
			}
		}

		int answer = 0;
		int[] points = {1, 2, 4, 8};

		for (int i = 0; i < 4; i++) {
			if (gears.get(i).get(START) != '0')
				answer += points[i];
		}

		System.out.println(answer);
	}

}
