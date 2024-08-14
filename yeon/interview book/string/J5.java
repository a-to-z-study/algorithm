package string;

public class J5 {

	int start;
	int maxLength;

	public String longestPalindrome(String s) {
		int length = s.length();

		if (length < 2) {
			return s;
		}

		for (int i = 0; i < length; i++) {
			extend(s, i, i + 1);
			extend(s, i, i + 2);
		}

		return s.substring(start, start + maxLength);
	}

	private void extend(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}

		if (maxLength < right - left - 1) {
			start = left + 1;
			maxLength = right - left - 1;
		}
	}

}
