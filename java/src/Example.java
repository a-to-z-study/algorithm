import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example {

	static class Member implements Comparable<Member> {
		String name;
		int age;

		public Member(String name, int age) {
			this.name = name;
			this.age = age;
		}

		@Override
		public int compareTo(Member o) {
			return this.name.compareTo(o.name);
		}
	}

	public static void array() {
		// Arrays.asList()는 기존 arr와 같은 참조를 가지고 고정된 크기 제한, 내부 요소들은 변경만 가능(추가, 삭제는 불가)
		Integer[] arr = {1, 2, 3};
		List<Integer> list = Arrays.asList(arr);
		// list.add(4) UnsupportedOperationException

		Arrays.binarySearch(new Integer[] {1, 2, 3, 4, 5, 6}, 2); // 정렬된 배열 이진 탐색


	}

	public static void collection() {
		List<Member> members = new ArrayList<>();
		members.add(new Member("bean", 100));
		members.add(new Member("yeon", 50));

		/*
		 * 	Collections.max(), Collections.min()
		 * 	Comparable, Comparator 없으면 에러
		 *   클래스에 Comparable를 구현하고 Comparator를 파라미터로 전달하면 Comparator로 적용
		 * */
		Collections.max(members);
		Collections.min(members, (o1, o2) -> o1.age - o2.age);

		// List.of()로 생성한 리스트는 불변(ImmutableCollections)이라 reverse()로 바꿀 수 없음
		Collections.reverse(members);
		List.of(members);

		// List -> array
		Member[] memberArr1 = members.toArray(new Member[0]);
		Member[] memberArr2 = members.toArray(new Member[] {});
		// Collections.binarySearch()
	}


	public static void math() {
		print("큰 값", Math.max(1, 5));
		print("작은 값", Math.min(1, 5));

		print("절대값", Math.abs(-2));

		print("올림", Math.ceil(1.5));
		print("내림", Math.floor(1.5));
		print("반올림", Math.round(1.5));

		print("%.nf -> n + 1에서 반올림", String.format("%.1f", 1.27));

		print("제곱", Math.pow(4, 4));
		print("제곱근", Math.sqrt(16));
	}

	public static void map() {
		Map<String, Integer> map = new HashMap<>();

		map.put("s", map.getOrDefault("s", 0) + 1);

		// Map에서 가장 큰 값
		Map.Entry<String, Integer> entry = Collections.max(
			map.entrySet(),
			Map.Entry.comparingByValue() // Comparator
		);
	}

	private static <T> void print(String message, T result) {
		System.out.println(message + " = " + result);
	}

	public static void main(String[] args) {
	}
}
