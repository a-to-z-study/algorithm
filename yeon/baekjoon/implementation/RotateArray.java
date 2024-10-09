package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class RotateArray {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());
		int R = Integer.parseInt(tokenizer.nextToken());

		List<List<Integer>> arrays = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String[] s = reader.readLine().split(" ");
			List<Integer> array = new ArrayList<>();

			for (String string : s) {
				array.add(Integer.parseInt(string));
			}

			arrays.add(array);
		}

		int[] topLeft = {0, 0};
		int lengthN = N;
		int lengthM = M;

		int[][] answer = new int[N][M];

		while (topLeft[0] < N / 2 && topLeft[1] < M / 2) {
			int[] topRight = {topLeft[0], topLeft[1] + lengthM - 1};
			int[] bottomLeft = {topLeft[0] + lengthN - 1, topLeft[1]};
			int[] bottomRight = {bottomLeft[0], topRight[1]};

			Deque<Integer> topWidth = new ArrayDeque<>(arrays.get(topLeft[0]).subList(topLeft[1], topRight[1]));
			Deque<Integer> bottomWidth = new ArrayDeque<>(arrays.get(bottomLeft[0]).subList(bottomLeft[1] + 1, bottomRight[1] + 1));
			Deque<Integer> leftHeight = new ArrayDeque<>();
			Deque<Integer> rightHeight = new ArrayDeque<>();

			for (int i = topLeft[0] + 1; i <= bottomLeft[0]; i++) {
				leftHeight.addLast(arrays.get(i).get(topLeft[1]));
			}

			for (int i = topRight[0]; i < bottomRight[0]; i++) {
				rightHeight.addLast(arrays.get(i).get(topRight[1]));
			}

			for (int i = 0; i < R; i++) {
				leftHeight.addFirst(topWidth.pollFirst());
				bottomWidth.addFirst(leftHeight.pollLast());
				rightHeight.addLast(bottomWidth.pollLast());
				topWidth.addLast(rightHeight.pollFirst());
			}

			for (int i = topLeft[1]; i < topRight[1] ; i++) {
				answer[topLeft[0]][i] = topWidth.pollFirst();
			}

			for (int i = bottomLeft[1] + 1; i <= bottomRight[1]; i++) {
				answer[bottomLeft[0]][i] = bottomWidth.pollFirst();
			}

			for (int i = topLeft[0] + 1; i <= bottomLeft[0] ; i++) {
				answer[i][topLeft[1]] = leftHeight.pollFirst();
			}

			for (int i = topRight[0]; i < bottomRight[0]; i++) {
				answer[i][topRight[1]] = rightHeight.pollFirst();
			}

			topLeft[0]++;
			topLeft[1]++;
			lengthN -= 2;
			lengthM -= 2;
		}

		StringBuilder builder = new StringBuilder();
		for (int[] ints : answer) {
			for (int anInt : ints) {
				builder.append(anInt).append(" ");
			}
			builder.append(System.lineSeparator());
		}

		System.out.println(builder);
	}

}
