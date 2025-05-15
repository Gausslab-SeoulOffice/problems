# 프로그래머스 - 전력망을 둘로 나누기
# https://school.programmers.co.kr/learn/courses/30/lessons/86491
# 간선 개수만큼 돌면서, 하나씩 끊어보고 DFS하여 두 subnetwork 차이의 최소값을 갱신한 뒤 다시 간선 복구하기를 반복한다.
# 이 풀이는 스택 기반이지만 재귀 기반으로도 풀어볼 예정.

def dfs(start_node, adj, n):  # dfs 로직
		# 기본 세팅
    visited = set([(start_node)])
    stack = [start_node]

		# 스택이 빌 때까지
    while stack:
        cur = stack.pop() # 방문

				# 탐색
        for nxt in range(n+1):
            if adj[cur][nxt] and nxt not in visited:
                visited.add(nxt)
                stack.append(nxt)

    return abs(len(visited)*2-n)  # 첫 번째 테스트케이스에서 한 덩어리가 3개가 나왔다면 3과 9(n)-3의(6의) 차이를 구해야 하므로.

def solution(n, wires):
    answer = 101
    adj = [[0]*(n+1) for _ in range(n+1)]

    for start, end in wires:  # 인접 행렬 완성
        adj[start][end] = 1
        adj[end][start] = 1

    for n1, n2 in wires:  # 간선의 갯수만큼 돌면서, 
        adj[n1][n2] = 0    # 하나씩 끊어보고 
        adj[n2][n1] = 0
        answer = min(answer, dfs(n1, adj, n)) # dfs
        adj[n1][n2] = 1    # 이후 간선 복구
        adj[n2][n1] = 1

    return answer
