package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P14891 {
	static int S_POLE = 1;
	static int CLOCK_DIR = 1;
	static int CLOCK_REVERSE_DIR = -1;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<Cogwheel> cogwheels = new ArrayList<>();

		for (int number = 0; number < 4; number++) {
			List<Integer> wheel = Arrays.stream(br.readLine().split(""))
				.mapToInt(Integer::parseInt)
				.boxed()
				.collect(Collectors.toList());

			cogwheels.add(new Cogwheel(wheel, number));
		}

		int k = Integer.parseInt(br.readLine());

		int[] rotateArr;

		while (k > 0) {
			String input = br.readLine();

			int number = Character.getNumericValue(input.charAt(0)) - 1;
			int dir = Character.getNumericValue(input.charAt(2));

			rotateArr = new int[4];
			rotateArr[number] = dir;
			Cogwheel cogwheel = cogwheels.get(number);
			Cogwheel nextCogwheel;

			Cogwheel posCogwheel = cogwheel;
			for (int left = cogwheel.number - 1; left >= 0; left--) {
				nextCogwheel = cogwheels.get(left);

				if (!posCogwheel.isReversePole(nextCogwheel)) {
					break;
				}

				rotateArr[nextCogwheel.number] = (rotateArr[posCogwheel.number] * - 1);
				posCogwheel = nextCogwheel;
			}

			posCogwheel = cogwheel;
			for (int right = cogwheel.number + 1; right < 4; right++) {
				nextCogwheel = cogwheels.get(right);

				if (!posCogwheel.isReversePole(nextCogwheel)) {
					break;
				}

				rotateArr[nextCogwheel.number] = (rotateArr[posCogwheel.number] * - 1);
				posCogwheel = nextCogwheel;
			}

			for (int i = 0; i < 4; i++) {
				if (rotateArr[i] != 0) {
					cogwheels.get(i).rotate(rotateArr[i]);
				}
			}

			k--;
		}

		int score = 0;
		for (int i = 0; i < 4; i++) {
			score += cogwheels.get(i).calculateScore();
		}

		System.out.println(score);
	}

	static class Cogwheel {
		List<Integer> wheel;
		int number;

		public Cogwheel(List<Integer> wheel, int number) {
			this.wheel = wheel;
			this.number = number;
		}

		void rotate(int clockDir) {
			if (clockDir == CLOCK_DIR) {
				wheel.add(0, wheel.remove(wheel.size() - 1));
			} else {

				wheel.add(wheel.remove(0));
			}
		}

		boolean isReversePole(Cogwheel other) {
			if (this.number > other.number && this.getPole(6) != other.getPole(2)) {
				return true;
			}
			if (this.number < other.number && this.getPole(2) != other.getPole(6)) {
				return  true;
			}

			return false;
		}

		int getPole(int dir) {
			return wheel.get(dir);
		}

		int calculateScore() {
			if (wheel.get(0) == S_POLE) {
				return (int) Math.pow(2, number);
			}

			return 0;
		}
	}
}
