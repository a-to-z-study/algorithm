package level2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class ParkingFeeCalculation {

	public int[] solution(int[] fees, String[] records) {
		Map<Integer, Deque<Integer>> recordsMap = new HashMap<>();

		for (String record : records) {
			StringTokenizer tokenizer = new StringTokenizer(record);
			String time = tokenizer.nextToken();
			Integer carNumber = Integer.parseInt(tokenizer.nextToken());

			if (!recordsMap.containsKey(carNumber)) {
				recordsMap.put(carNumber, new ArrayDeque<>());
			}

			int minutes = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
			recordsMap.get(carNumber).addLast(minutes);
		}

		List<List<Integer>> parkingFee = new ArrayList<>();
		int timeLimit = 23 * 60 + 59;

		for (Map.Entry<Integer, Deque<Integer>> record : recordsMap.entrySet()) {
			Integer carNumber = record.getKey();
			Deque<Integer> recordsDeque = record.getValue();
			int totalTime = 0;

			while (!recordsDeque.isEmpty()) {
				Integer inTime = recordsDeque.pollFirst();

				if (recordsDeque.isEmpty()) {
					totalTime += timeLimit - inTime;
					break;
				}

				Integer outTime = recordsDeque.pollFirst();
				totalTime += outTime - inTime;
			}

			if (totalTime <= fees[0]) {
				parkingFee.add(List.of(carNumber, fees[1]));
				continue;
			}
			// fees[0]: 기본 시간 fees[1]: 기본 요금
			// fees[2]: 단위 시간 fees[3]: 단위 요금
			int fee = fees[1] + (int)Math.ceil(((totalTime - fees[0]) / (double)fees[2])) * fees[3];
			parkingFee.add(List.of(carNumber, fee));
		}

		parkingFee.sort(Comparator.comparingInt(value -> value.get(0)));

		return parkingFee.stream().mapToInt(value -> value.get(1)).toArray();
	}

}
