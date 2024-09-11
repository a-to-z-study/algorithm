package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RobotOnConveyorBelt {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		int N = Integer.parseInt(tokenizer.nextToken()); // 내리는 위치
		int K = Integer.parseInt(tokenizer.nextToken()); // 종료 조건 (내구도가 0인 칸의 개수)

		int[] durability = new int[2 * N]; // 내구도 배열
		boolean[] hasRobot = new boolean[2 * N]; // 로봇 존재 여부

		tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < 2 * N; i++) {
			durability[i] = Integer.parseInt(tokenizer.nextToken());
		}

		int start = 0; // 시작 위치
		int zeroDurabilityCount = 0; // 내구도가 0인 칸 개수
		int steps = 0; // 진행 단계

		while (zeroDurabilityCount < K) {
			steps++;

			// 벨트가 한 칸 회전한다
			start = (start - 1 + 2 * N) % (2 * N);
			int dropPosition = (start + N - 1) % (2 * N); // 내리는 위치

			// 내리는 위치에 로봇이 있으면 로봇을 제거한다
			if (hasRobot[dropPosition]) {
				hasRobot[dropPosition] = false;
			}

			// 가장 먼저 올라간 로봇부터 순차적으로 이동시킨다
			// 내리는 위치에 있는 로봇이 가장 오래된 로봇이기 때문에
			// 내리는 위치부터 역순으로 탐색한다
			// i 초기화 : 내리는 위치
			// i 변화 : 왼쪽으로 이동
			// i 종료 조건 : 시작 지점
			for (int i = dropPosition; i != start; i = (i - 1 + 2 * N) % (2 * N)) {
				int next = (i + 1) % (2 * N);

				// 해당 위치에 로봇이 있고, 다음 칸에 로봇이 없으며, 다음 칸의 내구도가 0 이상인 경우 이동이 가능하다
				if (hasRobot[i] && !hasRobot[next] && durability[next] > 0) {
					hasRobot[i] = false;
					hasRobot[next] = true;
					durability[next]--; // 내구도 감소

					if (durability[next] == 0) {
						zeroDurabilityCount++;
					}
				}
			}

			// 내리는 위치에 도착한 로봇은 내려간다
			if (hasRobot[dropPosition]) {
				hasRobot[dropPosition] = false;
			}

			// 올리는 위치에 로봇을 올린다
			if (durability[start] > 0 && !hasRobot[start]) {
				hasRobot[start] = true;
				durability[start]--; // 내구도 감소

				if (durability[start] == 0) {
					zeroDurabilityCount++;
				}
			}
		}

		System.out.println(steps);
	}

}
