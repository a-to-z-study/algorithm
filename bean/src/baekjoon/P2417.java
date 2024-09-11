package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2417 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());

		long low = 0;
		long high = n;
		long mid = 0;

		while (low < high) {
			mid = (low + high) / 2;

			if (Math.pow(mid, 2) < n) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		System.out.println(low);
	}
}
