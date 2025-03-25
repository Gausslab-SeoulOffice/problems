# 백준 7576번 - 토마토
# 최대한 많은 토마토가 익은 최소일수를 구하는 문제다.
# 따라서 최단거리 구하기의 일종이므로 BFS가 적합하다.

import sys
input = sys.stdin.readline
from collections import deque

def BFS(r, c):
  r, c = queue.popleft()

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

ans = -1 # 토마토가 모두 익지는 않은 경우가 default
queue = deque()

# 처음에는 익은 토마토가 하나밖에 없다.
# 이를 이용하여 박스 안을 돌며 시작점을 찾는다.
for r in range(n):
  for c in range(m):
    if box[r][c] == 1:
      queue.append((r, c))

while queue:
  BFS(r, c) # 순회

# 날짜 구하기
for line in box:
  for t in line:
    if t == 0: # 하나라도 안 익은 토마토가 있으면 종료
      print(-1)
      exit(0)
    else: # 안 익은 토마토가 해당 줄에 없으면 익은 날짜를 갱신
      ans = max(ans, t)

print(ans - 1) # 익었는지 여부 판단을 위해 1을 더했으므로, 그만큼을 빼야 함
