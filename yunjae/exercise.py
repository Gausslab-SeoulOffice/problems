# 백준 1956 - 운동
# https://www.acmicpc.net/problem/1956

# Floyd-Warshall을 이용해 비용이 가장 적게 드는 사이클을 찾는다
# 이 방법을 쓰면 3중 for문을 쓰게 되므로 PyPy3으로 제출해야만 통과한다

V, E = map(int, input().split())

# 행렬에 비용(거리) 저장
dist = [[int(1e9)] * (V+1) for _ in range(V+1)]
for _ in range(E):
    start, end, cost = map(int, input().split())
    dist[start][end] = cost

# 3중 for문을 돌며 비용 업데이트
# 경유지 k, 출발지 i, 도착지 j
for k in range(1, V+1):
    for i in range(1, V+1):
        for j in range(1, V+1):
            if dist[i][k] + dist[k][j] < dist[i][j]:
                dist[i][j] = dist[i][k] + dist[k][j]

# 사이클은 출발지와 도착지가 같을 경우에 생긴다. 따라서 i --> i에 대해서만 확인
answer = 1e9
for i in range(1, V+1):
    answer = min(answer, dist[i][i])
    
# 최소값이 없으면 -1, 있으면 최소값 출력
if answer == 1e9:
    print(-1)
else:
    print(answer)
