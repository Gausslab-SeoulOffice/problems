# 프로그래머스 - 배달
# https://school.programmers.co.kr/learn/courses/30/lessons/12978
# Dijkstra 알고리즘 활용하는 대표적 예제 (visited 배열을 사용하지 않음)

import heapq as hq

def solution(N, road, K):
    def dijkstra(start):
        nonlocal dist, graph

        heap = []
        hq.heappush(heap, (0, start))
        dist[start] = 0
        
        while heap:     # 힙을 다 돌 때까지
            d, now = hq.heappop(heap) # 현재 가장 짧은 거리와 위치를 꺼내서
            
            # 이미 더 짧은 최적경로로 갱신되어있는 노드를 다시 처리하지 않음
            if dist[now] < d:
                continue

            else:
                for nxt, c in graph[now]:
                    cost = d + c
                    if cost < dist[nxt]:               # 지금 발견한 새 경로 cost가 현재 알고 있는 최단거리보다 짧으면
                        dist[nxt] = cost               # 거리를 더한 뒤 dist에 반영하고 
                        hq.heappush(heap, (cost, nxt)) # 힙에도 넣는다
    
    answer = 0
    
    dist = [float('inf')]*(N+1)  # 최단경로를 기록함
    graph = [[] for _ in range(N+1)]

    # road의 정보를 그래프에 양방향 반영
    for r in road:
        graph[r[0]].append((r[1], r[2]))
        graph[r[1]].append((r[0], r[2]))

    start = 1  # 항상 1번 마을부터 시작
    dijkstra(start)

    # 해당 최단 경로가 K 이하인 노드의 개수 파악
    for i in dist:
        if i <= K:
            answer += 1
        
    return answer
