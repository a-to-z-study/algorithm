from collections import Counter


def solution(k, tangerine):
    counter = Counter(tangerine)
    answer = 0
    total = 0

    for item in counter.most_common():
        answer += 1
        total += item[1]

        if total >= k:
            return answer
