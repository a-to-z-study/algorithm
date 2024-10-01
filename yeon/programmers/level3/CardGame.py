def solution(coin, cards):
    n = len(cards)
    target = len(cards) + 1
    card_index = n // 3
    have = set(cards[:card_index])
    candidates = set()
    answer = 1

    while card_index + 1 < n:

        card1 = cards[card_index]
        card2 = cards[card_index + 1]

        card_index += 2

        candidates.add(card1)
        candidates.add(card2)

        can_pass = False

        for card in have:
            if target - card in have:
                have.remove(card)
                have.remove(target - card)
                can_pass = True
                break

        if can_pass:
            answer += 1
            continue

        if coin and candidates:
            for card in candidates:
                if target - card in have:
                    coin -= 1
                    candidates.remove(card)
                    have.remove(target - card)
                    can_pass = True
                    break

        if can_pass:
            answer += 1
            continue

        if coin >= 2 and candidates:
            for card in candidates:
                if target - card in candidates:
                    coin -= 2
                    candidates.remove(card)
                    candidates.remove(target - card)
                    can_pass = True
                    break

        if can_pass:
            answer += 1
            continue
        else:
            break

    return answer


print(solution(4, [3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4]))
print(solution(3, [1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11, 12]))
print(solution(2, [5, 8, 1, 2, 9, 4, 12, 11, 3, 10, 6, 7]))
print(solution(10, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18]))
