import sys

sys.setrecursionlimit(10 ** 6)


def solution(maps):
    answer = []

    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    maps = [list(map) for map in maps]

    def find_island(x, y, food):
        maps[x][y] = 'X'

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < len(maps) and 0 <= ny < len(maps[0]) and maps[nx][ny] != 'X':
                food = find_island(nx, ny, food + int(maps[nx][ny]))

        return food

    for x in range(len(maps)):
        for y in range(len(maps[x])):
            if maps[x][y] != 'X':
                answer.append(find_island(x, y, int(maps[x][y])))

    return sorted(answer) if answer else [-1]
