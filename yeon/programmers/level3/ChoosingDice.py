from collections import Counter
from itertools import combinations
from itertools import product


def solution(dice):
    dice_indexes = [i for i in range(len(dice))]
    groups = list(combinations(dice_indexes, len(dice) // 2))
    win_count = [0] * len(groups)

    for i in range(len(groups) // 2):
        a = i
        b = len(groups) - 1 - i

        a_group = [dice[dice_number] for dice_number in groups[a]]
        b_group = [dice[dice_number] for dice_number in groups[b]]

        a_cases = Counter([sum(case) for case in product(*a_group)])
        b_cases = Counter([sum(case) for case in product(*b_group)])

        a_win = 0
        b_win = 0

        for a_number, a_count in a_cases.items():
            for b_number, b_count in b_cases.items():
                if a_number > b_number:
                    a_win += a_count * b_count
                elif a_number < b_number:
                    b_win += b_count * a_count

        win_count[a] = a_win
        win_count[b] = b_win

    answer = []

    for dice_index in groups[win_count.index(max(win_count))]:
        answer.append(dice_index + 1)

    return answer


print(solution([[1, 2, 3, 4, 5, 6], [3, 3, 3, 3, 4, 4], [1, 3, 3, 4, 4, 4], [1, 1, 4, 4, 5, 5]]))
print(solution([[1, 2, 3, 4, 5, 6], [2, 2, 4, 4, 6, 6]]))
print(solution([[40, 41, 42, 43, 44, 45], [43, 43, 42, 42, 41, 41], [1, 1, 80, 80, 80, 80], [70, 70, 1, 1, 70, 70]]))
