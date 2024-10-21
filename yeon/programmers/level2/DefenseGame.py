from heapq import heappop
from heapq import heappush


def solution(n, k, enemy):
    answer = 0
    heap = []

    for e in enemy:
        n -= e
        heappush(heap, -e)

        while n < 0 and k:
            n -= heappop(heap)
            k -= 1

        if n < 0:
            return answer

        answer += 1

    return answer
