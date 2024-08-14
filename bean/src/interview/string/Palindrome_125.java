package interview.string;

public class Palindrome_125 {
	public boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (!Character.isLetterOrDigit(s.charAt(start))) {
				start++;
				continue;
			}
			if (!Character.isLetterOrDigit(s.charAt(end))) {
				end--;
				continue;
			}
			if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	public boolean isPalindrome2(String s) {
		String filteredStr = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

		String reversedStr = new StringBuilder(filteredStr)
			.reverse()
			.toString();

		return filteredStr.equals(reversedStr);
	}
}
