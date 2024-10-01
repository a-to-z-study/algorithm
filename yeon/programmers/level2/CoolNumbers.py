def solution(s: str):
    if len(s) < 3:
        return -1

    answer = -1

    for index in range(len(s) - 2):
        if s[index] == s[index + 1] == s[index + 2]:
            answer = max(answer, int(s[index:index + 3]))

    return answer


print(solution('12223'))
print(solution('111999333'))
print(solution('123'))
