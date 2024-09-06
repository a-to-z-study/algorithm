import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RecommendCandidates {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int totalCount = Integer.parseInt(reader.readLine());
		String[] votes = reader.readLine().split(" ");

		List<Integer> candidates = new ArrayList<>(N);
		int[] points = new int[101];

		for (String vote : votes) {
			int student = Integer.parseInt(vote);
			boolean alreadyRegistered = candidates.contains(student);

			if (candidates.size() < N && !alreadyRegistered) {
				candidates.add(student);
				points[student]++;
				continue;
			}

			if (alreadyRegistered) {
				points[student]++;
				continue;
			}

			int min_vote_count = totalCount;
			int student_number_to_remove = 0;
			int student_frame_to_remove = 0;

			for (int i = 0; i < candidates.size(); i++) {
				if (points[candidates.get(i)] < min_vote_count) {
					min_vote_count = points[candidates.get(i)];
					student_number_to_remove = candidates.get(i);
					student_frame_to_remove = i;
				}
			}

			candidates.remove(student_frame_to_remove);
			points[student_number_to_remove] = 0;

			candidates.add(student);
			points[student]++;
		}

		candidates.sort(Integer::compareTo);

		StringBuilder builder = new StringBuilder();

		for (Integer candidate : candidates) {
			builder.append(candidate).append(" ");
		}

		builder.delete(builder.length() - 1, builder.length());

		System.out.println(builder);
	}

}
