# SWEA 4881 - 배열최소합
# https://velog.io/@wltn39/SWEA-4881-%EB%B0%B0%EC%97%B4%EC%B5%9C%EC%86%8C%ED%95%A9
# 종료조건, backtracking, DFS 탐색 활용

t = int(input())
for tc in range(t):
    n = int(input())
    matrix = [list(map(int, input().split())) for _ in range(n)]
    ans = 100
    check = [0] * n
    dfs(0, 0)
    print(f'{tc + 1} {ans}')

def dfs(depth, tmp):
    global ans
    
    # 재귀 종료 조건 (마지막 depth까지 채웠으면 정답을 갱신하고 return)
    if depth == n:
        ans = min(ans, tmp)
        return
    
    # 백트래킹
    if tmp >= ans:
        return
    
    # 재귀 DFS 탐색
    for i in range(n):
        if not check[i]:
            check[i] = 1
            tmp += matrix[depth][i]
            
            dfs(depth+1, tmp)
            
            check[i] = 0  # 재검색할 수 있도록 방문 해제
            tmp -= matrix[depth][i]
