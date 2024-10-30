from collections import Counter


def solution(topping):
    answer = 0

    if len(topping) == 1:
        return answer

    counter_left = set(topping[:1])
    counter_right = Counter(topping[1:])

    left_types = 1
    right_types = len(set(topping[1:]))

    if left_types == right_types:
        answer += 1

    for index in range(1, len(topping)):
        t = topping[index]

        if t not in counter_left:
            left_types += 1
            counter_left.add(t)

        counter_right[t] -= 1

        if not counter_right[t]:
            right_types -= 1

        if left_types == right_types:
            answer += 1

    return answer
