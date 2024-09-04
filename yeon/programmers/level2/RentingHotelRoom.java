package level2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class RentingHotelRoom {

	public int solution(String[][] book_time) {
		Arrays.sort(book_time, (a, b) -> {
			int compareEnd = a[0].compareTo(b[0]);

			if (compareEnd != 0) {
				return compareEnd;
			}

			return a[1].compareTo(b[1]);
		});

		int answer = 1;

		String[] split = book_time[0][1].split(":");
		int endTime = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);

		Queue<Integer> queue = new PriorityQueue<>();
		queue.add(endTime);

		for (int i = 1; i < book_time.length; i++) {
			String[] newGuest = book_time[i];
			String[] start_split = newGuest[0].split(":");
			String[] end_split = newGuest[1].split(":");
			int start = Integer.parseInt(start_split[0]) * 60 + Integer.parseInt(start_split[1]);
			int end = Integer.parseInt(end_split[0]) * 60 + Integer.parseInt(end_split[1]);


			// 퇴실 시간 + 10분 <= 입실 시간
			if (queue.peek() + 10 <= start) {
				queue.poll();
			}

			queue.add(end);

			answer = Math.max(answer, queue.size());
		}

		return answer;
	}

}
