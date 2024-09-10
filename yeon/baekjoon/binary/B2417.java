package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2417 {
	// 문제: 정수 제곱근

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(reader.readLine());

		long low = 0;
		long high = n;

		while (low < high) {
			long mid = low + (high - low) / 2;

			if (Math.pow(mid, 2) < n) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		System.out.println(low);
	}

}
