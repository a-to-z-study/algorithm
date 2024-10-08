def solution(n, tops):
    dp = [[0] * 2 for _ in range(n)]  # 겹치는 타일을 사용한 경우, 겹치는 타일을 사용하지 않은 경우
    dp[0] = [1, 3] if tops[0] == 1 else [1, 2]

    for i in range(1, n):
        if tops[i] == 1:  # 윗변에 붙인 정삼각형이 있는 경우
            # 겹치는 타일을 사용하여 오른쪽 마름모 타일로 덮는 경우
            # 겹치는 타일을 사용하지 않고 다른 타일로 덮는 경우

            # [이전에 겹치는 타일을 사용한 경우 + 이전에 겹치는 타일을 사용하지 않은 경우,
            #  이전에 겹치는 타일을 사용한 경우 * (위쪽, 오른쪽 정삼각형과 함께 마름모 타일로 덮기) +
            #  이전에 겹치는 타일을 사용하지 않은 경우 * (위쪽, 오른쪽, 왼쪽 정삼각형과 함께 마름모 타일로 덮기)]
            dp[i] = [(dp[i - 1][0] + dp[i - 1][1]) % 10007,
                     (dp[i - 1][0] * 2 + dp[i - 1][1] * 3) % 10007]
        else:
            dp[i] = [(dp[i - 1][0] + dp[i - 1][1]) % 10007,
                     (dp[i - 1][0] + dp[i - 1][1] * 2) % 10007]

    return sum(dp[-1]) % 10007


print(solution(4, [1, 1, 0, 1]))
print(solution(2, [0, 1]))
print(solution(10, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]))
