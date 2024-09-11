package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1789 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());
		long count = 1;
		long sum = 1;
		long i = 2;

		while (sum + i <= n) {
			sum += i;
			i++;
			count++;
		}

		System.out.println(count);
	}
}
