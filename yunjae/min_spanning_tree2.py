# 백준 1197 - 최소 스패닝 트리
# https://www.acmicpc.net/problem/1197
# Prim으로 다시 구현

import heapq

V, E = map(int, input().split())
adj_list = [[] for _ in range(V + 1)]

for _ in range(E):
  start, end, weight = map(int, input().split())
  adj_list[start].append((weight, end))
  adj_list[end].append((weight, start))

visited = [0] * (V + 1)
min_heap = [(0, 1)]      # 최소힙 시작정점은 1번
total_weight = 0

while min_heap:
  weight, now = heapq.heappop(min_heap)
  if visited[now]:
    continue
  visited[now] = 1
  total_weight += weight

  for next_weight, next_node in adj_list[now]:
    if not visited[next_node]:
      heapq.heappush(min_heap, (next_weight, next_node))

print(total_weight)
