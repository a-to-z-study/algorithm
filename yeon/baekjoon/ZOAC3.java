import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ZOAC3 {

	public static void main(String[] args) throws IOException {
		Map<Character, int[]> left_keyboard = new HashMap<>();
		Map<Character, int[]> right_keyboard = new HashMap<>();

		left_keyboard.put('q', new int[]{0, 0});
		left_keyboard.put('w', new int[]{0, 1});
		left_keyboard.put('e', new int[]{0, 2});
		left_keyboard.put('r', new int[]{0, 3});
		left_keyboard.put('t', new int[]{0, 4});
		left_keyboard.put('a', new int[]{1, 0});
		left_keyboard.put('s', new int[]{1, 1});
		left_keyboard.put('d', new int[]{1, 2});
		left_keyboard.put('f', new int[]{1, 3});
		left_keyboard.put('g', new int[]{1, 4});
		left_keyboard.put('z', new int[]{2, 0});
		left_keyboard.put('x', new int[]{2, 1});
		left_keyboard.put('c', new int[]{2, 2});
		left_keyboard.put('v', new int[]{2, 3});

		right_keyboard.put('y', new int[]{0, 5});
		right_keyboard.put('u', new int[]{0, 6});
		right_keyboard.put('i', new int[]{0, 7});
		right_keyboard.put('o', new int[]{0, 8});
		right_keyboard.put('p', new int[]{0, 9});
		right_keyboard.put('h', new int[]{1, 5});
		right_keyboard.put('j', new int[]{1, 6});
		right_keyboard.put('k', new int[]{1, 7});
		right_keyboard.put('l', new int[]{1, 8});
		right_keyboard.put('b', new int[]{2, 4});
		right_keyboard.put('n', new int[]{2, 5});
		right_keyboard.put('m', new int[]{2, 6});

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String firstLine = reader.readLine();
		String[] split_firstLine = firstLine.split(" ");

		char leftHand = split_firstLine[0].charAt(0);
		char rightHand = split_firstLine[1].charAt(0);
		String target = reader.readLine();

		int answer = 0;

		for (char alphabet : target.toCharArray()) {
			if (leftHand != alphabet && rightHand != alphabet) {
				if (left_keyboard.containsKey(alphabet)) {
					answer += getDistance(left_keyboard.get(leftHand), left_keyboard.get(alphabet));
					leftHand = alphabet;
				} else {
					answer += getDistance(right_keyboard.get(rightHand), right_keyboard.get(alphabet));
					rightHand = alphabet;
				}
			}

			answer++;
		}

		System.out.println(answer);
	}

	private static int getDistance(int[] a, int[] b) {
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}

}
