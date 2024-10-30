from math import gcd


def find_gcd(arr):
    result = arr[0]

    for num in arr[1:]:
        result = gcd(result, num)

        if result == 1:  # GCD가 1인 경우 더 이상 계산할 필요가 없음
            break

    return result


def solution(arrayA, arrayB):
    gcdA = find_gcd(arrayA)
    gcdB = find_gcd(arrayB)

    def is_valid_gcd(candidate, other_array):
        return all(x % candidate != 0 for x in other_array)

    # 철수가 가진 카드들의 GCD가 영희 카드들에 대해 유효한지 확인
    resultA = gcdA if is_valid_gcd(gcdA, arrayB) else 0

    # 영희가 가진 카드들의 GCD가 철수 카드들에 대해 유효한지 확인
    resultB = gcdB if is_valid_gcd(gcdB, arrayA) else 0

    return max(resultA, resultB)
