package string;

import java.util.ArrayList;
import java.util.List;

public class J937 {

	public String[] reorderLogFiles(String[] logs) {
		List<String> digitLogs = new ArrayList<>();
		List<String> letterLogs = new ArrayList<>();

		for (String log : logs) {
			int contentStartIndex = log.indexOf(' ') + 1;

			if (Character.isDigit(log.charAt(contentStartIndex))) {
				digitLogs.add(log);
			} else {
				letterLogs.add(log);
			}
		}

		letterLogs.sort((log1, log2) -> {
			String[] log1Split = log1.split(" ", 2);
			String[] log2Split = log2.split(" ", 2);

			int compared = log1Split[1].compareTo(log2Split[1]);

			if (compared == 0) {
				return log1Split[0].compareTo(log2Split[0]);
			} else {
				return compared;
			}
		});

		letterLogs.addAll(digitLogs);

		return letterLogs.toArray(new String[0]);
	}

}
