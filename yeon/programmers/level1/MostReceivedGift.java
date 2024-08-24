package level1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MostReceivedGift {

	public int solution(String[] friends, String[] gifts) {
		Map<String, Integer> gift_count = new HashMap<>();
		Map<String, Integer> gift_point = new HashMap<>();

		for (String gift : gifts) { // a b
			gift_count.put(gift, gift_count.getOrDefault(gift, 0) + 1);

			String[] names = gift.split(" ");
			gift_point.put(names[0], gift_point.getOrDefault(names[0], 0) + 1);
			gift_point.put(names[1], gift_point.getOrDefault(names[1], 0) - 1);
		}

		Map<String, Integer> will_receive = new HashMap<>();

		for (int i = 0; i < friends.length - 1; i++) {
			String friend_a = friends[i];

			for (int j = i + 1; j < friends.length; j++) {
				String friend_b = friends[j];

				int a_to_b;
				int b_to_a;

				a_to_b = gift_count.getOrDefault(String.format("%s %s", friend_a, friend_b), -1);
				b_to_a = gift_count.getOrDefault(String.format("%s %s", friend_b, friend_a), -1);

				if (a_to_b > b_to_a) {  // a가 b에게 준 기록이 더 많다면
					// a가 다음 달에 선물을 하나 받는다
					will_receive.put(friend_a, will_receive.getOrDefault(friend_a, 0) + 1);
				} else if (b_to_a > a_to_b) {  // b가 a에게 준 기록이 더 많다면
					// b가 다음 달에 선물을 하나 받는다
					will_receive.put(friend_b, will_receive.getOrDefault(friend_b, 0) + 1);
				} else {  // 서로 주고 받은 횟수가 같거나 주고 받은 적이 없는 경우에는 선물 지수가 큰 사람이 다음 달에 선물을 하나 받는다
					if (gift_point.getOrDefault(friend_a, 0) > gift_point.getOrDefault(friend_b, 0)) {
						will_receive.put(friend_a, will_receive.getOrDefault(friend_a, 0) + 1);
					} else if (gift_point.getOrDefault(friend_a, 0) < gift_point.getOrDefault(friend_b, 0)) {
						will_receive.put(friend_b, will_receive.getOrDefault(friend_b, 0) + 1);
					}
					// 선물 지수가 같다면 서로 선물을 주고 받지 않는다
				}
			}
		}

		if (will_receive.isEmpty()) {
			return 0;
		}

		return Collections.max(will_receive.values());
	}

}
