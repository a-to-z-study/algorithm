package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1789 {
	// 문제: 수들의 합

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(reader.readLine());

		long sum = 0;
		long number = 1;

		while (sum + number <= S) {
			sum += number;
			number++;
		}

		System.out.println(--number);
	}

}
