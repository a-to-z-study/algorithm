package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class B4659 {

	// 비밀번호 발음하기
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		String password;

		String open = "<";
		String close = ">";
		String is_acceptable = " is acceptable.";
		String is_not_acceptable = " is not acceptable.";
		Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'u', 'i', 'o'));

		while (!(password = reader.readLine()).equals("end")) {
			boolean hasVowels = false;
			boolean isAcceptable = true;
			int repeated = 0;

			int index = 0;

			while (index < password.length()) {
				// 모음을 한 개 이상 포함하고 있는지 확인한다
				// 모음이라면 +1 자음이라면 -1
				char charAt = password.charAt(index);

				if (vowels.contains(charAt)) {
					hasVowels = true;

					if (repeated < 0) {
						repeated = 0;
					}

					repeated++;
				} else {
					if (repeated > 0) {
						repeated = 0;
					}

					repeated--;
				}

				// 모음 또는 자음이 3번 연속으로 등장하는지 확인한다
				if (repeated == 3 || repeated == -3) {
					isAcceptable = false;
					break;
				}

				// 같은 글자가 두 번 연속해서 등장하는지 확인한다
				if (charAt != 'e' && charAt != 'o' && index < password.length() - 1 && charAt == password.charAt(index + 1)) {
					isAcceptable = false;
					break;
				}

				index++;
			}

			if (!hasVowels) {
				isAcceptable = false;
			}

			builder.append(open).append(password).append(close);

			if (isAcceptable) {
				builder.append(is_acceptable);
			} else {
				builder.append(is_not_acceptable);
			}

			builder.append(System.lineSeparator());
		}

		System.out.println(builder);
	}

}
