package level1;

public class DesktopCleanup {

	public int[] solution(String[] wallpaper) {
		int[] start = new int[]{50, 50};
		int[] end = new int[]{0, 0};

		for (int i = 0; i < wallpaper.length; i++) {
			String line = wallpaper[i];

			for (int j = 0; j < line.length(); j++) {
				if (line.charAt(j) == '#') {
					start[0] = Math.min(start[0], i);
					start[1] = Math.min(start[1], j);

					end[0] = Math.max(end[0], i);
					end[1] = Math.max(end[1], j);
				}
			}
		}

		return new int[]{start[0], start[1], end[0] + 1, end[1] + 1};
	}

}
