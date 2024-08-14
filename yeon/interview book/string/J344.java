package string;

public class J344 {

	public void reverseString(char[] s) {
		int left = 0;
		int right = s.length - 1;

		while (left < right) {
			char keeper = s[left];

			s[left] = s[right];
			s[right] = keeper;

			left++;
			right--;
		}
	}

}
