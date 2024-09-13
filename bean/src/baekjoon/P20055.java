package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P20055 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input1 = br.readLine().split(" ");

		int N = Integer.parseInt(input1[0]);
		int K = Integer.parseInt(input1[1]);

		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Belt> belts = new ArrayList<>();
		while (st.hasMoreTokens()) {
			belts.add(new Belt(Integer.parseInt(st.nextToken())));
		}

		final ConveyorBelt conveyorBelt = new ConveyorBelt(belts, N);


		int step = 0;

		while (conveyorBelt.durabilityZeroCount < K) {
			step++;
			conveyorBelt.move();
			conveyorBelt.moveRobot();
			conveyorBelt.goUp();
		}

		System.out.println(step);
	}

	static class ConveyorBelt {
		List<Belt> belts;
		int start;
		int end;
		int durabilityZeroCount;

		public ConveyorBelt(List<Belt> belts, int n) {
			this.belts = belts;
			this.start = 0;
			this.end = n - 1;
		}

		void move() {
			start--;
			if (start < 0) {
				start = belts.size() - 1;
			}

			if (belts.get(end).hasRobot) {
				belts.get(end).hasRobot = false;
			}

			end--;
			if (end < 0) {
				end = belts.size() - 1;
			}

			if (belts.get(end).hasRobot) {
				belts.get(end).hasRobot = false;
			}
		}

		void goUp() {
			Belt startBelt = belts.get(start);

			if (!startBelt.hasRobot && startBelt.durability > 0) {
				startBelt.hasRobot = true;
				startBelt.durability--;

				if (startBelt.durability == 0) {
					durabilityZeroCount++;
				}
			}
		}

		void moveRobot() {
			Belt next = belts.get(end);
			if (next.hasRobot) {
				next.hasRobot = false;
			}

			int pos = end;

			while (pos != start) {
				pos--;
				if (pos < 0) {
					pos = belts.size() - 1;
				}

				Belt current = belts.get(pos);
				moveNextBelt(current, next);
				next = current;
			}

			moveNextBelt(belts.get(start), next);
		}

		private void moveNextBelt(Belt current, Belt next) {
			if (current.hasRobot && next.durability > 0 && !next.hasRobot) {
				current.hasRobot = false;
				next.hasRobot = true;
				next.durability--;
				if (next.durability == 0) {
					durabilityZeroCount++;
				}
			}
		}
	}

	static class Belt {
		int durability;

		boolean hasRobot;

		public Belt(int durability) {
			this.durability = durability;
			this.hasRobot = false;
		}
	}
}
