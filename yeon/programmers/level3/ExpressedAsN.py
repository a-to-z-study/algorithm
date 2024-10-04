def solution(N, number):
    if N == number:
        return 1

    results = {1: {N}}

    def calculate(list_A, list_B):
        numbers = set()

        for i in list_A:
            for j in list_B:
                numbers.add(i + j)
                numbers.add(i - j)
                numbers.add(i * j)

                if j != 0:
                    numbers.add(i // j)

        return numbers

    for i in range(2, 9):  # 8번보다 더 많이 사용한 경우 -1을 return하기 때문에 8회 이상 반복할 필요가 없다
        temp = {int(str(N) * i)}  # 55, 555, 5555, 55555, ... 우선 자릿수를 늘린 숫자를 하나 넣어둔다

        for j in range(1, i):
            # i == 2, j == 1인 경우
            # N을 1번 사용한 것과 N을 1번 사용한 것과의 연산

            # i == 3, j == 1인 경우
            # N을 1번 사용한 것과, N을 2번 사용한 것과의 연산
            # i == 3, j == 2인 경우
            # N을 2번 사용한 것과, N을 1번 사용한 것과의 연산

            # i == 4, j == 1인 경우
            # N을 1번 사용한 것과, N을 3번 사용한 것과의 연산
            # i == 4, j == 2인 경우
            # N을 2번 사용한 것과, N을 2번 사용한 것과의 연산
            # i == 4, j == 3인 경우
            # N을 3번 사용한 것과, N을 1번 사용한 것과의 연산
            temp.update(calculate(results[j], results[i - j]))

            if number in temp:  # 원하는 숫자가 완성되었을 때 바로 return
                return i

        results[i] = temp

    return -1


print(solution(5, 12))
print(solution(2, 11))
