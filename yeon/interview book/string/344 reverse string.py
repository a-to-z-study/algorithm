from typing import List


def reverseString(s: List[str]) -> None:
    """
    Do not return anything, modify s in-place instead.
    """
    length = len(s)

    for index in range(length // 2):
        s[index], s[length - index - 1] = s[length - index - 1], s[index]
