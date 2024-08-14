from collections import Counter
from typing import List
import re


def mostCommonWord(paragraph: str, banned: List[str]) -> str:
    banned_set = set(banned)
    new_paragraph = re.sub('[^a-zA-Z0-9]', ' ', paragraph).lower()
    counter = Counter(new_paragraph.split())

    for word, _ in sorted(counter.items(), key=lambda x: -x[1]):
        if word not in banned_set:
            return word
