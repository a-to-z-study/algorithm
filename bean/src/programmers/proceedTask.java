package programmers;

import java.util.*;

public class proceedTask {
	public String[] solution(String[][] plans) {
		List<String> answer = new ArrayList<>();
		Deque<Subject> waitQ = new ArrayDeque<>();
		Queue<Subject> subjectQ = new PriorityQueue<>();

		for (String[] plan : plans) {
			subjectQ.offer(new Subject(plan[0], plan[1], plan[2]));
		}

		int currentTime = subjectQ.peek().start;
		waitQ.offerFirst(subjectQ.poll());
		Subject currentSubject;

		while (!subjectQ.isEmpty() || !waitQ.isEmpty()) {
			if (!subjectQ.isEmpty() && subjectQ.peek().start == currentTime) {
				currentSubject = subjectQ.poll();
			} else {
				currentSubject = waitQ.pollFirst();
			}

			if (currentSubject != null) {
				currentSubject.start++;

				if (currentSubject.isEnd()) {
					answer.add(currentSubject.name);
				} else {
					waitQ.offerFirst(currentSubject);
				}
			}

			currentTime++;
		}

		return answer.toArray(new String[0]);
	}

	static class Subject implements Comparable<Subject> {
		String name;
		int start;
		int end;

		Subject(String name, String startTime, String playtime) {
			this.name = name;
			String[] startTimeArr = startTime.split(":");
			start = ((Integer.parseInt(startTimeArr[0]) * 60) + (Integer.parseInt(startTimeArr[1])));
			end = start + Integer.parseInt(playtime);
		}

		public boolean isEnd() {
			return start == end;
		}

		@Override
		public int compareTo(Subject o) {
			if (this.start == o.start) {
				return this.end - o.end;
			}

			return this.start - o.start;
		}
	}
}
