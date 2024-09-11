package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P20436 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<Character, Key> leftKeys = new HashMap<>();
		leftKeys.put('q', new Key('q', 0, 0));
		leftKeys.put('w', new Key('w', 0, 1));
		leftKeys.put('e', new Key('e', 0, 2));
		leftKeys.put('r', new Key('r', 0, 3));
		leftKeys.put('t', new Key('t', 0, 4));
		leftKeys.put('a', new Key('a', 1, 0));
		leftKeys.put('s', new Key('s', 1, 1));
		leftKeys.put('d', new Key('d', 1, 2));
		leftKeys.put('f', new Key('f', 1, 3));
		leftKeys.put('g', new Key('g', 1, 4));
		leftKeys.put('z', new Key('z', 2, 0));
		leftKeys.put('x', new Key('x', 2, 1));
		leftKeys.put('c', new Key('c', 2, 2));
		leftKeys.put('v', new Key('v', 2, 3));

		Map<Character, Key> rightKeys = new HashMap<>();
		rightKeys.put('y', new Key('y', 0, 5));
		rightKeys.put('u', new Key('u', 0, 6));
		rightKeys.put('i', new Key('i', 0, 7));
		rightKeys.put('o', new Key('o', 0, 8));
		rightKeys.put('p', new Key('p', 0, 9));
		rightKeys.put('h', new Key('h', 1, 5));
		rightKeys.put('j', new Key('j', 1, 6));
		rightKeys.put('k', new Key('k', 1, 7));
		rightKeys.put('l', new Key('l', 1, 8));
		rightKeys.put('b', new Key('b', 2, 4));
		rightKeys.put('n', new Key('n', 2, 5));
		rightKeys.put('m', new Key('m', 2, 6));

		final String[] init = br.readLine().split(" ");
		final char[] inputKeys = br.readLine().toCharArray();

		Key leftPos = leftKeys.get(init[0].charAt(0));
		Key rightPos = rightKeys.get(init[1].charAt(0));

		int time = 0;
		for (char nextKey : inputKeys) {
			if (leftKeys.containsKey(nextKey)) {
				time += leftKeys.get(nextKey).distance(leftPos);
				leftPos = leftKeys.get(nextKey);
			}
			else {
				time += rightKeys.get(nextKey).distance(leftPos);
				rightPos = rightKeys.get(nextKey);
			}
		}

		System.out.println(time);
	}

	static class Key {
		char ch;
		int y;
		int x;

		public Key(char ch, int y, int x) {
			this.ch = ch;
			this.y = y;
			this.x = x;
		}

		public int distance(Key before) {
			return Math.abs(before.x - this.x) + Math.abs(before.y - this.y);
		}
	}
}
