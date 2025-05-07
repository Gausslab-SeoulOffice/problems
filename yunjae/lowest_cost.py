# 백준 1916 - 최소비용 구하기
# https://www.acmicpc.net/problem/1916
# Dijkstra로 풀어야 시간초과가 나지 않는다

from heapq import heappush, heappop

N = int(input())   # 노드 수
M = int(input())   # 간선 수

graph = [[] for _ in range(N+1)]           # 1-based index graph

for _ in range(M):
    s, e, c = map(int, input().split())    # start, end, cost
    graph[s].append((e, c))                # start와 end 사이를 가중치가 담긴 간선으로 이어준다 

S, E = map(int, input().split())
costs = [987654321] * (N + 1)

def dijkstra(start):
    heap = []
    visited = set()
    heappush(heap, (0, start))
    costs[start] = 0
    
    while heap:
        cur_c, cur_v = heappop(heap)  # 현재 cost, 현재 vertex
        
        # 이미 예전에 더 짧은 거리를 찾았다면 건너뛴다. (최소 cost만 pop하여 쓴다는 뜻)
        if costs[cur_v] < cur_c:
            continue

        # 다음 방문 후보지 탐색
        for nxt_v, nxt_c in graph[cur_v]:
            sum_c = cur_c + nxt_c
            if sum_c >= costs[nxt_v]:  # 효율성이 떨어지는 거리라면 업데이트 불필요
                continue
            
            costs[nxt_v] = sum_c    # 더 효율적인 거리로 update
            heappush(heap, (sum_c, nxt_v))
            
dijkstra(S)
print(costs[E])
