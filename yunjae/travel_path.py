# 프로그래머스 - 여행 경로
# https://school.programmers.co.kr/learn/courses/30/lessons/43164

# (출발, 도착) 쌍에 따라 경로를 맞춰가야 하니 그래프가 필요하다
# DFS와 백트래킹을 활용한다

from collections import defaultdict

def solution(tickets):
    T = len(tickets)
    graph = defaultdict(lambda: defaultdict(int)) # 2차원 defaultdict 구현은 이렇게
    
    # 티켓 정보를 그래프에 옮긴다
    for dep, arr in tickets:
        graph[dep][arr] += 1
    
    paths = []  # 가능한 모든 경로들
    
    def dfs(path, T):
        nonlocal graph, paths
        
        # 티켓을 모두 소모했으면 경로 추가
        # (mutability issue 방지 위해 얕은 복사)
        if T == 0:
            paths.append(path.copy())
            return

        dep = path[-1] # 현재 위치
        
        # 현재 위치 dep에서 갈 수 있는 모든 도착지 arr들을 정렬해서 '사전순으로' 순회
        for arr in sorted(graph[dep].keys()):
            # 티켓이 있으면 사용하고 DFS.
            # 없다면 이미 다른 경로에서 사용한 것이니 건너뜀
            if graph[dep][arr]:
                graph[dep][arr] -= 1
                dfs(path+[arr], T-1) # 다음 경로로 이동
                graph[dep][arr] += 1 # 재귀가 끝나면 티켓 수 복구 (다른 경로를 탐색할 수 있도록)
    
    dfs(['ICN'], T) # 인천공항에서 출발
    paths.sort()
    
    return paths[0]
