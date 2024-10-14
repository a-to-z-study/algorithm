from collections import deque


def solution(x, y, n):
    if x == y:
        return 0

    queue = deque([(x, 0)])
    used = set([x])

    while queue:
        number, count = queue.popleft()

        candidates = [number + n, number * 2, number * 3]

        for candidate in candidates:
            if candidate == y:
                return count + 1

            if candidate < y and candidate not in used:
                queue.append((candidate, count + 1))
                used.add(candidate)

    return -1
