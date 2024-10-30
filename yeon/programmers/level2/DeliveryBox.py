def solution(order):
    priority = [0] * len(order)

    for i in range(0, len(order)):
        priority[order[i] - 1] = i + 1

    stack = []
    current = 1

    for box in priority:
        while stack and stack[-1] == current:
            stack.pop()
            current += 1

        if box == current:
            current += 1
        else:
            stack.append(box)

    while stack and stack[-1] == current:
        stack.pop()
        current += 1

    return current - 1


def solution(order):
    answer = 0
    stack = []

    for idx, num in enumerate(order):
        stack.append(idx + 1)  # idx + 1번째에 트럭에 실어야 한다

        while stack and stack[-1] == order[answer]:  # stack[-1]번째 실어야 하는 택배 == answer번째 실어야 하는 택배의 벨트 등장 순서
            stack.pop()
            answer += 1

    return answer
