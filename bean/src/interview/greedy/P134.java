package interview.greedy;

import java.util.Arrays;

public class P134 {

	/*
	* 	순환 경로를 따라 n개의 주유소가 있으며, i번째 주유소의 주유량은 gas[i]입니다.
	*   i번째 역에서 다음 (i + 1)번째 역까지 이동하는 데 휘발유 비용이 듭니다.
	*   주유소 중 한 곳에서 빈 탱크로 출발합니다.
	*
	*   두 개의 정수 배열 gas와 비용이 주어지면 시계 방향으로 회로를 한 번만 이동
	* 	- 할 수 있으면 시작 주유소의 인덱스를 반환하고
	*   - 그렇지 않으면 -1을 반환합니다.
	*
	*	솔루션이 존재하는 경우 고유함이 보장
	* */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
			return -1;
		}

		//  a b c d e f g
		//  a -> b -> c -> d -> (x) -> e
		// (a -> b -> c -> d) 까지는 이동 가능 보장
		//                             e -> f -> g -> (a -> b -> c -> d)
		int start = 0;
		int fuel = 0;

		for (int i = 0; i < gas.length; i++) {
			fuel += (gas[i] - cost[i]);
			if (fuel < 0) {
				start = i + 1;
				fuel = 0;
			}
		}
		return start;
	}

	public static void main(String[] args) {
		System.out.println(new P134().canCompleteCircuit(new int[] {2, 3, 4}, new int[] {3, 4, 3,}));
	}
}
