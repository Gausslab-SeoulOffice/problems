# 백준 1197 - 최소신장트리
# https://www.acmicpc.net/problem/1197
# Kruskal 개념 정리를 위한 문제입니다.

import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

# Kruskal (Union-Find)
def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(x, y):
    x_root = find(x)
    y_root = find(y)
    if x_root != y_root:
        parent[y_root] = x_root
        return True
    return False

V, E = map(int, input().split())
edges = []

for _ in range(E):
    start, end, weight = map(int, input().split())
    edges.append((weight, start, end))

# 간선 가중치 기준으로 정렬
edges.sort()

# Union Find를 위해 부모 배열 초기화
parent = [i for i in range(V + 1)]

total_weight = 0
for weight, start, end in edges:
    if union(start, end):
        total_weight += weight

print(total_weight)
