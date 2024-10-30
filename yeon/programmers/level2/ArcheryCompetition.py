from itertools import product


def solution(n, info):
    info.reverse()  # 0점부터 10점까지 (오름차순으로 변경)

    all_cases = list(product([True, False], repeat=10))  # True: 어피치보다 화살을 1개 더 쏜다 / False: 아예 화살을 쏘지 않는다
    win_cases = []  # 라이언이 이기는 경우
    gap = 0  # 점수 차이

    for case in all_cases:
        arrows = n  # 남은 화살의 수
        lion = [0] * 11
        lion_point = 0  # 라이언의 점수
        apeach_point = 0  # 어피치의 점수

        for index, shoot in enumerate(case):
            apeach_shoot = info[index + 1]

            if shoot and arrows > apeach_shoot:
                lion[index + 1] = apeach_shoot + 1
                arrows -= apeach_shoot + 1
                lion_point += index + 1
            elif shoot and arrows <= apeach_shoot:
                break
            elif apeach_shoot:
                apeach_point += index + 1
        else:
            lion[0] = arrows  # 남은 화살을 모두 0점에 쏘기

            if lion_point > apeach_point:
                if gap < lion_point - apeach_point:
                    gap = lion_point - apeach_point
                    win_cases = [lion]
                elif gap == lion_point - apeach_point:
                    win_cases.append(lion)

    if not win_cases:
        return [-1]

    win_cases.sort(reverse=True)

    return list(reversed(win_cases[0]))
