package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P17609 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			String str = br.readLine();
			sb.append(matchPalindrome(str, 0, str.length() - 1)).append(System.lineSeparator());
			n--;
		}

		System.out.println(sb);
	}

	private static int matchPalindrome(String str, int lt, int rt) {
		boolean match = true;

		if (str.equals(new StringBuilder(str).reverse().toString())) {
			return 0;
		}

		while (lt < rt) {
			if (str.charAt(lt) != str.charAt(rt)) {
				match = false;
				break;
			}
			rt--;
			lt++;
		}

		if (match) {
			return 0;
		}

		String str1 = new StringBuilder(str).deleteCharAt(lt).toString();
		String str2 = new StringBuilder(str).deleteCharAt(rt).toString();

		if (str1.equals(new StringBuilder(str1).reverse().toString()) ||
			(str2.equals(new StringBuilder(str2).reverse().toString()))) {
			return 1;
		}

		return 2;
	}
}
