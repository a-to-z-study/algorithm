def find_next_positions(board, current_position):
    dr = [0, 0, 1, -1]
    dc = [1, -1, 0, 0]
    next_positions = []

    for d in range(4):
        nr = current_position[0] + dr[d]
        nc = current_position[1] + dc[d]

        if 0 <= nr < len(board) and 0 <= nc < len(board[0]) and board[nr][nc] == 1:
            next_positions.append((nr, nc))

    return next_positions


def search(board, position_a, position_b, turn):
    if turn % 2 == 0:  # A 차례인 경우
        next_positions = find_next_positions(board, position_a)
    else:  # B 차례인 경우
        next_positions = find_next_positions(board, position_b)

    if not next_positions:  # 이동할 발판이 없는 경우
        return turn % 2 != 0, turn  # A가 이긴다면 True, B가 이긴다면 False

    if position_a == position_b:  # 현재 캐릭터가 이동할 수 있으면서 둘이 같은 발판 위에 서있는 경우 현재 캐릭터의 승리
        return turn % 2 == 0, turn + 1

    win = []
    lose = []

    if turn % 2 == 0:  # A 이동 차례
        board[position_a[0]][position_a[1]] = 0  # 캐릭터가 떠난 발판은 0으로 변경

        for nr, nc in next_positions:
            is_win, count = search(board, [nr, nc], position_b, turn + 1)

            if is_win:
                win.append(count)
            else:
                lose.append(count)

        board[position_a[0]][position_a[1]] = 1  # 다시 복구
    else:  # B 이동 차례
        board[position_b[0]][position_b[1]] = 0

        for nr, nc in next_positions:
            is_win, count = search(board, position_a, [nr, nc], turn + 1)

            if not is_win:
                win.append(count)
            else:
                lose.append(count)

        board[position_b[0]][position_b[1]] = 1

    if win:
        return turn % 2 == 0, min(win)
    else:
        return turn % 2 != 0, max(lose)


def solution(board, aloc, bloc):
    return search(board, aloc, bloc, 0)[1]


print(solution([[1, 1, 1], [1, 1, 1], [1, 1, 1]], [1, 0], [1, 2]))
print(solution([[1, 1, 1], [1, 0, 1], [1, 1, 1]], [1, 0], [1, 2]))
print(solution([[1, 1, 1, 1, 1]], [0, 0], [0, 4]))
print(solution([[1]], [0, 0], [1, 2]))
