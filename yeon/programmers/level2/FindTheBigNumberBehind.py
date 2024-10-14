import heapq


def solution(numbers):
    heap = []
    heapq.heappush(heap, (numbers[0], 0))

    answer = [-1] * len(numbers)

    for index, number in enumerate(numbers[1:]):
        while heap and number > heap[0][0]:
            _, i = heapq.heappop(heap)
            answer[i] = number

        heapq.heappush(heap, (number, index + 1))

    return answer
