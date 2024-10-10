package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class P21758 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer inputs = new StringTokenizer(br.readLine());

		int[] arr = new int[n];
		int lt = n - 1;
		int rt = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(inputs.nextToken());

			if (arr[i] < arr[lt]) {
				lt = Math.min(lt, i);
			}
			if (arr[i] < arr[rt]) {
				rt = Math.max(rt, i);
			}
		}

		int bee1 = 0;
		int bee2 = lt;
		int honeyPot = n - 1;
		boolean right = true;

		if (arr[0] > arr[n - 1]) {
			bee1 = n - 1;
			bee2 = rt;
			honeyPot = 0;
		}
		if (arr[0] == arr[n - 1] && lt > (n - 1 - rt)) {
			bee1 = n - 1;
			bee2 = rt;
			honeyPot = 0;
		}

		if (honeyPot == 0) {
			right = false;
		}

		int sum = 0;

		System.out.println("bee1 = " + bee1 + ", bee2 = " + bee2 + ", pot = " + honeyPot);
		if (right) {
			sum -= arr[bee2];
			while (bee1 < n - 1) {
				bee1++;
				bee2++;
				sum += arr[bee1];
				if (bee2 < n) {
					sum += arr[bee2];
				}
			}
		}
		if (!right) {
			sum -= arr[bee2];
			while (bee1 > 0) {
				bee1--;
				bee2--;
				sum += arr[bee1];
				if (bee2 >= 0) {
					sum += arr[bee2];
				}}
		}

		System.out.println(sum);
	}
}














