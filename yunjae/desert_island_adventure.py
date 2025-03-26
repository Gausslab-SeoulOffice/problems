# 프로그래머스 - 무인도 여행
# https://school.programmers.co.kr/learn/courses/30/lessons/154540

# BFS, DFS 모두로 풀 수 있음 (여기서는 BFS부터)
# delta 탐색을 적용해서 품

from collections import deque

def solution(maps):
    def BFS(y, x): # 열, 행
        Q = deque([(y, x)])
        visited.add((y, x))
        days = int(maps[y][x])

        while Q:
            y, x = Q.popleft()

            # delta 탐색
            for d in range(4):
                ny, nx = y + dy[d], x + dx[d]

                if 0 <= ny < N and 0 <= nx < M and maps[ny][nx] != 'X' and (ny, nx) not in visited:
                    Q.append((ny, nx))
                    visited.add((ny, nx))       # delta 탐색에서는 
                    days += int(maps[ny][nx])   # 이 두 줄을 추가해줌

        return days

    N, M = len(maps), len(maps[0])
    dy, dx = [-1, 1, 0, 0], [0, 0, -1, 1]  # up, down, left, right
    visited = set()
    answer = []

    for i in range(N):
        for j in range(M):
            if maps[i][j] != 'X' and (i, j) not in visited:
                answer.append(BFS(i, j)) # (i, j)에서부터 섬이 계속되는 곳까지 탐색을 시작함

    return sorted(answer) if answer else [-1]
