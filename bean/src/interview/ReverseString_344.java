package interview;

public class ReverseString_344 {
	public void reverseString(char[] s) {
		int lt = 0;
		int rt = s.length - 1;

		char characterKeeper;
		while (lt < rt) {
			characterKeeper = s[lt];
			s[lt] = s[rt];
			s[rt] = characterKeeper;
			lt++;
			rt--;
		}
	}
}
