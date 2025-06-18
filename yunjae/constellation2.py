# 백준 4386 - 별자리 만들기
# https://www.acmicpc.net/problem/4386
# Prim 연습용 문제

import sys
input = sys.stdin.readline

import math
import heapq as hq

N = int(input())
stars = [tuple(map(float, input().split())) for _ in range(N)]
graph = [[] for _ in range(N)]

# 별들 간 비용 계산 저장
# Kruskal은 모든 간선을 한꺼번에 간선 리스트로 정리해서 처리하지만,
# Prim은 하나의 정점에서 시작해서 인접 간선만 점진적 확장하므로 정점 기준 인접 리스트로 저장함
for i in range(N - 1):
    for j in range(i+1, N):
        dist = math.sqrt((stars[i][0] - stars[j][0])**2 + (stars[i][1] - stars[j][1])**2)    
        graph[i].append((dist, j))
        graph[j].append((dist, i))
    
visited = [False] * N
min_heap = [(0, 0)]      # (비용, 시작 정점)
result = 0
count = 0

while min_heap and count < N:
    cost, u = hq.heappop(min_heap)   # 가장 비용이 적은 간선 정보 꺼냄: (u로 가는 비용, 연결할 정점)
    if visited[u]:                   # 연결할 정점 
        continue
    visited[u] = True
    result += cost
    count += 1

    for next_cost, v in graph[u]:
        if not visited[v]:
            hq.heappush(min_heap, (next_cost, v))

print(round(result, 2))
