package structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class B10815 {
	// 문제: 숫자 카드

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		String[] cards = reader.readLine().split(" ");
		int M = Integer.parseInt(reader.readLine());
		String[] numbers = reader.readLine().split(" ");

		Set<Integer> cards_set = new HashSet<>();
		for (String card : cards) {
			cards_set.add(Integer.valueOf(card));
		}

		StringBuilder builder = new StringBuilder();
		for (String number : numbers) {
			if (cards_set.contains(Integer.valueOf(number))) {
				builder.append("1 ");
			} else {
				builder.append("0 ");
			}
		}
		builder.delete(builder.length() - 1, builder.length());

		System.out.println(builder);
	}

}
