import math


def solution(k, d):
    def distance(x2, y2):
        return math.sqrt(math.pow(0 - x2, 2) + math.pow(0 - y2, 2))

    multiple = int(d / k)
    answer = 0

    for x in range(multiple + 1):
        x *= k
        y = multiple * k

        while distance(x, y) > d and multiple:
            multiple -= 1
            y = multiple * k

        if multiple < 0:
            continue

        answer += multiple + 1

    return answer
