import re

def isPalindrome(s: str) -> bool:
    new_s = re.sub('[^a-zA-Z0-9]', '', s).lower()

    return new_s == new_s[::-1]
