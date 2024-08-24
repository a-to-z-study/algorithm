package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MostReceivedgift {
	public int solution(String[] friends, String[] gifts) {
		Map<String, Integer> friendIndexMap = new HashMap<>();
		for (int i = 0; i < friends.length; i++) {
			friendIndexMap.put(friends[i], i);
		}

		int[][] giftRecord = new int[friends.length][friends.length];
		int[] giftPoint = new int[friends.length];

		for (String gift : gifts) {
			String[] giftDir = gift.split(" ");
			int from = friendIndexMap.get(giftDir[0]);
			int to = friendIndexMap.get(giftDir[1]);

			giftRecord[from][to] += 1;
			giftPoint[from]++;
			giftPoint[to]--;
		}

		// 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받는다.
		// 두 사람이 선물을 주고받은 기록이 없거나 같다면, 선물 지수가 더 큰 사람이 선물을 하나 받는다.
		// friends index 번호
		int[] receiveGiftCount = new int[friends.length];

		for (int from = 0; from < friends.length; from++) {
			for (int to = 0; to < friends.length; to++) {
				if (from == to) { continue; }
				if (giftRecord[from][to] > giftRecord[to][from]) {
					receiveGiftCount[from] += 1;
					continue;
				}
				// 내가 받은 게 많거나 같은 경우
				if (giftRecord[from][to] < giftRecord[to][from]) {
					continue;
				}
				if (giftPoint[from] > giftPoint[to]) {
					receiveGiftCount[from] += 1;
				}
			}
		}

		return Arrays.stream(receiveGiftCount)
			.max()
			.orElseGet(() -> 0);
	}
}
