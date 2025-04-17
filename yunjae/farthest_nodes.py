# 프로그래머스 - 가장 먼 노드
# https://school.programmers.co.kr/learn/courses/30/lessons/49189
# DFS는 시간초과가 나는 일이 많다. BFS를 쓰겠음

from collections import deque, defaultdict

def solution(n, vertex):
    # edge를 그래프로 고쳐쓰기
    # (파이썬 구현 사례들은 defaultdict를 많이 쓴다)
    graph = defaultdict(list)
    for v in vertex:
        graph[v[0]].append(v[1])
        graph[v[1]].append(v[0])

    # BFS 순회        
    def bfs(start):  
        Q = deque([start])
        dist = [-1 for _ in range(n+1)] # n으로 하면 index out of range 에러가 뜬다
        # dist가 visited와 다른 점은, 누적거리를 저장한다는 것 
        # (이 값이 -1이면 미방문이라는 뜻이므로 visited의 역할도 한다)
        dist[start] = 0
        
        while Q:
            node = Q.popleft()
            for neighbor in graph[node]:
                if dist[neighbor] == -1:
                    dist[neighbor] = dist[node] + 1
                    Q.append(neighbor)
        return dist
    
    # 누적 dist가 가장 큰 사례들을 count하면 원하는 답이 나옴
    distances = bfs(1)
    max_dist = max(distances)
    return distances.count(max_dist)
