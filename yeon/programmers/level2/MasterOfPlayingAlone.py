def solution(cards):
    answer = 0

    for index, card in enumerate(cards):
        number_to_open = card - 1
        opened = [False] * len(cards)
        opened[index] = True
        group1_count = 1

        while not opened[number_to_open]:
            opened[number_to_open] = True
            number_to_open = cards[number_to_open] - 1
            group1_count += 1

        if group1_count == len(cards):
            continue

        for i, c in enumerate(cards):
            if not opened[i]:
                number_to_open = c - 1
                opened_copy = opened
                opened_copy[i] = True
                group2_count = 1

                while not opened_copy[number_to_open]:
                    opened_copy[number_to_open] = True
                    number_to_open = cards[number_to_open] - 1
                    group2_count += 1

                answer = max(answer, group1_count * group2_count)

    return answer
