# 백준 7576번 - 토마토
# 최대한 많은 토마토가 익은 최소일수를 구하는 문제다.
# 따라서 최단거리 구하기의 일종이므로 BFS가 적합하다.

import sys
input = sys.stdin.readline
from collections import deque

def BFS(r, c):
  r, c = queue.popleft()

  # delta 탐색
  for d in range(4):
    nr, nc = r + dr[d], c + dc[d]

    if 0 <= nr < n and 0 <= nc < m and box[nr][nc] == 0: # 갈 곳이 더 남아있고 아직 안 익었을 경우
      queue.append((nr, nc))
      box[nr][nc] = box[r][c] + 1  # 익은 날짜를 기록한다 (다 익는 데 걸리는 일수를 구하려면 필요함)

# 입력부
m, n = map(int, input().split())
box = [list(map(int, input().split())) for _ in range(n)]

# delta 값
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

# 익은 토마토가 하나 이상 있을 수 있다.
# 이를 이용하여 박스 안을 돌며 시작점을 찾는다.
queue = deque()
for r in range(n):
  for c in range(m):
    if box[r][c] == 1:
      queue.append((r, c))

BFS(queue)

ans = 0
# 날짜 구하기
for row in box:
  if 0 in row:
    print(-1)
    exit(0)
  ans = max(ans, max(row))

print(ans - 1) # 처음 익은 토마토(1)에서 시작했으니 1을 빼준다
