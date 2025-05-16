# 백준 10971 - 외판원 문제
# https://www.acmicpc.net/problem/10971
# 재귀 DFS와 비트마스킹을 활용해서 풀 수 있다.

import sys
sys.setrecursionlimit(10**6)

input = sys.stdin.readline

def dfs(now, cost, depth, visited):
    global ans, N
    
    # 재귀 탈출용
    if depth == N:   
        if cost_matrix[now][0]:              # 마지막 도착지에 출발지(0)로 가는 길이 있는 경우
            cost += cost_matrix[now][0]      # 그때에만 경로가 완성되므로 누적합
            ans = min(ans, cost)             # 최소값(정답) 갱신
            return
        else:                                # 0으로 가는 길이 없으면 탐색 종료
            return

    # 백트래킹 (유망하지 않으면 탐색 중단)
    if cost > ans:
        return
    
    # 비트마스킹으로 방문 여부 확인
    for after in range(N):
        if not cost_matrix[now][after] or visited & (1 << after): # 다음 지점이 없거나, 있더라도 이미 방문
            continue
        # 재귀를 시키며, 그때그때 정수 visited를 업데이트(방문했다고 표시)
        dfs(after, cost+cost_matrix[now][after], depth+1, visited | (1 << after))  

N = int(input())
cost_matrix = [list(map(int, input().split())) for _ in range(N)]

ans = 987654321

dfs(0, 0, 1, 1)

print(ans)
