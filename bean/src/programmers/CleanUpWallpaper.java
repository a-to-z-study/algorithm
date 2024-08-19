package programmers;

public class CleanUpWallpaper {
	public int[] solution(String[] wallpaper) {
		int lux = Integer.MAX_VALUE;
		int luy = Integer.MAX_VALUE;
		int rdx = Integer.MIN_VALUE;
		int rdy = Integer.MIN_VALUE;

		for (int i = 0; i < wallpaper.length; i++) {
			String line = wallpaper[i];
			for (int j = 0; j < line.length(); j++) {
				if (line.charAt(j) == '#') {
					if (j < lux) {
						lux = j;
					}if (i < luy) {
						luy = i;
					}
					if (j > rdx) {
						rdx = j;
					}
					if (i > rdy) {
						rdy = i;
					}
				}
			}
		}

		return new int[]{luy, lux, rdy + 1, rdx + 1};
	}
}
