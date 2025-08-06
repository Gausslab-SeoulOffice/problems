# 프로그래머스 - 피로도
# https://school.programmers.co.kr/learn/courses/30/lessons/87946
# DFS를 통한 완전탐색

def solution(k, dungeons):
    def dfs(k, cnt, dungeons):
        nonlocal answer
        if cnt > answer:
            answer = cnt    # 최대값 갱신
        for i in range(len(dungeons)):
            # 아직 방문이 안 됐고, 필요한 피로도보다 k가 크거나 같을 경우
            if not visited[i] and k >= dungeons[i][0]:
                visited[i] = True
                dfs(k-dungeons[i][1], cnt+1, dungeons)
                visited[i] = False
    
    answer = 0
    visited = [False for _ in range(len(dungeons))]
    dfs(k, 0, dungeons)
    
    return answer
