# 프로그래머스 - 섬 연결하기
# https://school.programmers.co.kr/learn/courses/30/lessons/42861
# 풀이3. Prim

import heapq as hq

def solution(n, costs):
    graph = [[] for _ in range(n)]
    
    # 정점 간 비용을 그래프에 저장
    for cost in costs:
        graph[cost[0]].append((cost[1], cost[2]))
        graph[cost[1]].append((cost[0], cost[2]))
    
    start = 0
    visited = [False] * len(graph)
    min_heap = []
    result = 0
    
    # 그래프의 내용을 힙에 push
    for end, cost in graph[start]:
        hq.heappush(min_heap, (cost, start, end))
    
    # 첫 정점 방문
    visited[start] = True
    
    while min_heap:
        cost, start, end = hq.heappop(min_heap) # 가장 비용이 적은 간선 정보 꺼냄
        if visited[end]:
            continue
        visited[end] = True
        result += cost
        
        for next_end, next_cost in graph[end]:
            hq.heappush(min_heap, (next_cost, end, next_end))

    return result
