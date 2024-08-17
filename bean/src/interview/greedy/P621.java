package interview.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class P621 {
	public int leastInterval(char[] tasks, int n) {
		int[] taskCounts = new int[26];
		for (char task : tasks) {
			taskCounts[task - 'A'] += 1;
		}

		Queue<Integer> taskQueue = new PriorityQueue<>((n1, n2) -> n2 - n1);
		for (int taskCount : taskCounts) {
			if (taskCount > 0) {
				taskQueue.add(taskCount);
			}
		}

		int result = 0;
		while (!taskQueue.isEmpty()) {
			List<Integer> keepTasks = new ArrayList<>();
			int interval = 0;
			int len = taskQueue.size();
			while (interval < len) {
				if (interval > n) { // n보다 커지면 다시 우선순위 작업부터 처리하기 위해 break
					break;
				}

				int remainingTaskCount = taskQueue.poll() - 1;
				if (remainingTaskCount > 0) {
					keepTasks.add(remainingTaskCount);
				}

				result++;
				interval++;
			}

			if (!keepTasks.isEmpty()) {
				result += (n + 1 - interval);
			}

			taskQueue.addAll(keepTasks);
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(new P621().leastInterval(new char[] {'A', 'A', 'A', 'B', 'B', 'B'}, 2));
	}
}
