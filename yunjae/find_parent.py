# 백준 11725: 트리의 부모 찾기
# https://www.acmicpc.net/problem/11725 

# 루트 없는 트리가 주어지고, 트리의 루트를 1이라고 할 때, 각 노드의 부모를 구하는 문제
# BFS로 풀기 위해서는 인접리스트 형태로 인풋을 바꿔줘야 한다
# 우선 딕셔너리 형태로 그래프를 만들고 그걸 인접리스트로 고쳐씀

import sys
input = sys.stdin.readline
from collections import defaultdict, deque

# 입력부
N = int(input())
tree = [list(map(int, input().split())) for _ in range(N-1)]

# 그래프 그리기
graph = defaultdict(list)
graph[0] = []

# key: value 쌍에서 value가 딕셔너리가 되게 하고 += 연산자로 처리하기 쉽게 하려면 defaultdict를 쓰면 됨
for i in range(N-1):
    graph[tree[i][0]] += [tree[i][1]]
    graph[tree[i][1]] += [tree[i][0]]

# 그래프를 key에 따라 한번 정렬해준 뒤 인접리스트로 고쳐쓰기
graph = dict(sorted(graph.items(), key = lambda i: i[0]))
adj_list = list(graph.values())
for _ in range(N):
    adj_list[_] = sorted(adj_list[_])

# BFS 순회하며 각 노드의 parent 파악하기
Q = deque([1])
visited = set()
parent = [0] * N

while Q:
    now = Q.popleft()
    visited.add(now)

    for dest in adj_list[now]:
        if dest not in visited:
            Q.append(dest)
            parent[dest-1] = now

# 결과 출력
for i in range(1, N):
    print(parent[i])
