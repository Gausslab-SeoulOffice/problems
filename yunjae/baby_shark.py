# 백준 16236 - 아기 상어
# https://www.acmicpc.net/problem/16236
# 조건부 델타탐색 + BFS
# 시간복잡도를 줄이기 위해 우선순위큐도 활용

import sys
from collections import deque
import heapq

input = sys.stdin.readline

N = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]

# 델타탐색 방향
dx = [-1, 0, 0, 1]
dy = [0, -1, 1, 0]

# 아기상어 초기 정보
for i in range(N):
    for j in range(N):
        if graph[i][j] == 9:
            x, y = i, j
            graph[i][j] = 0

size = 2
eat = 0
time = 0

# (지나쳐갈 수 있는 물고기가 있는) 이동 가능한 칸을 탐색하며 지나가는 BFS
def bfs(sx, sy, size):
    visited = [[-1] * N for _ in range(N)]
    visited[sx][sy] = 0
    q = deque()
    q.append((sx, sy))        # 시작 좌표 큐에 추가
    fish = []

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < N and visited[nx][ny] == -1:
                if graph[nx][ny] <= size:
                    visited[nx][ny] = visited[x][y] + 1
                    q.append((nx, ny))
                    # 먹을 물고기를 파악하는 함수
                    if 0 < graph[nx][ny] < size:
                        heapq.heappush(fish, (visited[nx][ny], nx, ny))

    return fish

# 메인루프(상어가 더 이상 먹을 물고기가 없을 때까지)
while True:
    fish_list = bfs(x, y, size)
    if not fish_list: # 먹을 물고기가 없다면 루프 종료
        break

    dist, fx, fy = heapq.heappop(fish_list)
    time += dist
    eat += 1
    graph[fx][fy] = 0
    x, y = fx, fy

    # 자기 몸집과 같은 수의 물고기를 먹으면 아기상어 몸집이 1만큼 늘어남
    if eat == size:
        size += 1
        eat = 0

print(time)
