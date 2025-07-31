# 백준 1956 - 운동
# Floyd-Warshall을 그대로 쓰되 코드를 refactoring

INF = int(1e9)

V, E = map(int, input().split())
dist = [[INF] * (V+1) for _ in range(V+1)]

for _ in range(E):
    a, b, c = map(int, input().split())
    dist[a][b] = min(dist[a][b], c)  # 중복 간선 있을 수 있음

# Floyd-Warshall
for i in range(1, V+1):
    for j in range(1, V+1):
        for k in range(1, V+1):
            dist[j][k] = min(dist[j][k], dist[j][i] + dist[i][k])  # if문 대신 최소값 찾기로 대체

# i → ... → i 로 돌아오는 최소 사이클 찾기
answer = INF
for i in range(1, V+1):
    answer = min(answer, dist[i][i]) # if문 대신 최소값 찾기로 대체

print(answer if answer < INF else -1)
