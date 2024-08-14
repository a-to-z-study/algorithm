package string;

public class J125 {

	public boolean isPalindrome1(String s) {
		String filteredS = s.toLowerCase().replaceAll("[^a-z0-9]", "");
		String flippedS = new StringBuilder(filteredS).reverse().toString();

		return filteredS.equals(flippedS);
	}

	public boolean isPalindrome2(String s) {
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			if (!Character.isLetterOrDigit(s.charAt(left))) {
				left++;
			} else if (!Character.isLetterOrDigit(s.charAt(right))) {
				right--;
			} else {
				if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
					return false;
				}

				left++;
				right--;
			}
		}

		return true;
	}

}
