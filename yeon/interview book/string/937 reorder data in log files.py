from typing import List


def reorderLogFiles(logs: List[str]) -> List[str]:
    digit_logs = []
    letter_logs = []

    for log in logs:
        first_space_index = log.index(' ')
        identifier = log[:first_space_index]
        letter = log[first_space_index + 1:]

        if ''.join(letter.split()).isdigit():
            digit_logs.append(log)
        else:
            letter_logs.append([letter, identifier])

    letter_logs.sort()
    answer = [letter_log[1] + ' ' + letter_log[0] for letter_log in letter_logs] + digit_logs

    return answer
