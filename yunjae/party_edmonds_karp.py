# 백준 2367 - 파티
# https://www.acmicpc.net/problem/2367

# "최대유량 알고리즘"을 써서 풀어야 하는 문제
# 제한 조건이 있을 때, 그 조건을 지키는 한도 내에서 최대의 결과를 얻을 때 사용
# BFS를 기반으로 한 Ford-Fulkerson 알고리즘인 Edmonds-Karp 알고리즘을 활용하는 경우가 많다

# source에서부터 시작해 BFS를 해 가며, sink 로 갈 수 있는 제일 빠른 경로를 탐색
# 음식 제공량 한도를 '잔여 용량(residual)'이라고 보고 식을 세워서 푼다
# [풀이 순서]
# 1) source-손님 사이에 용량 X(=n+d+2)의 간선을 만든다
# 2) 각 사람이 만들 수 있는 음식에 대해서 용량 1의 간선을 만든다
# 3) 음식-sink 사이에 용량 D[i]의 간선을 만든다
# 4) 최대유량을 구한다

from collections import deque

n, k, d = map(int, input().split())
food = list(map(int, input().split()))

x = n + d + 2   # 노드의 총 수: source 1개 + 사람 n명 + 음식 d가지 + sink 1개이기 때문
source = 0      # 출발점인 source의 노드번호 
sink = x - 1    # 도착점인 sink의 노드번호 = n + d + 1)

capa = [{} for _ in range(x)]         # i번 노드에서 나가는 간선들의 용량 정보를 딕셔너리로 저장
flow = [[0]*x for _ in range(x)]      # i -> j 간의 유량을 2차원 리스트로 저장

# 사람 노드를 시작점과 연결
# 1~n: 사람 노드
for i in range(1, n+1):
  capa[source][i] = k  # 시작점에서 사람 i에게 최대 X개의 접시를 가저가게 함
  capa[i][source] = 0  # 역방향 간선 (flow를 업데이트하는 잔여 용량 그래프에 쓸 예정)

# 음식 노드를 도착점과 연결
# n+1 ~ n+d: 음식 노드
for i in range(1, d+1):
  food_node = n + i
  capa[food_node][sink] = food[i-1]  # 음식 노드를 사람 노드와 구분짓기 위함
  capa[sink][food_node] = 0

# 각 사람이 요리할 수 있는 음식과 연결
for i in range(1, n+1):
  _, *can_cook = map(int, input().split())
  for j in can_cook:
    food_node = n + j
    capa[i][food_node] = 1
    capa[food_node][i] = 0

# 잔여 용량이 남아있는 경로를 찾기 위해 큐를 이용하여 너비 우선 탐색
def BFS():
  Q = deque()
  Q.append(source)
  visited = [-1] * x        # 여기 저장되는 정보는 방문 Boolean이 아니라, 방문한 이전 노드의 번호 (역추적을 위해서임)
  visited[source] = source  # 출발점 방문 표시
  while Q:
    now = Q.popleft()
    for nxt in capa[now]:
      residual = capa[now][nxt] - flow[now][nxt]   # 잔여 용량 계산
      if visited[nxt] == -1 and residual > 0:      # 아직 방문하지 않고, 잔여 용량이 있다면
        visited[nxt] = now                         # 경로 역추적용으 이전 노드 저장
        if nxt == sink:                            # 도착점(sink)에 도착하면, 경로를 찾은 것이므로 방문기록 반환
          return visited
        Q.append(nxt)                              
  return None

# 최대 유량을 구하는 함수
def max_flow():
  total = 0                        # 총 유량
  while True:
    visited = BFS()                # source -> sink 로 가는 잔여 경로 탐색
    if not visited:                # 경로가 없다면 종료
      break
    path = []                      # 경로 저장용
    now = sink 
    bottleneck = float('inf')      # 최소유량 초기값(양의 무한대)
    
    # sink -> source 순으로 역추적
    while now != source:
      prev = visited[now]
      path.append((prev, now))                                            # 경로 저장
      bottleneck = min(bottleneck, capa[prev][now] - flow[prev][now])     # 현재 간선의 잔여 용량과 bottleneck 중 최소값 선택
      now = prev
    
    # 찾은 경로에 대해 유량 업데이트 (역추적하므로 reversed()를 사용한다)
    for prev, nxt in reversed(path):
      flow[prev][nxt] += bottleneck  # 정방향 간선에 유량 증가
      flow[nxt][prev] -= bottleneck  # 역방향 간선에 유량 삭감
    total += bottleneck              # 누적 유량에 bottleneck 더함
  return total

print(max_flow())
