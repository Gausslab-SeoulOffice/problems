# 백준 4386 - 별자리 만들기
# https://www.acmicpc.net/problem/4386
# Kruskal 연습용 문제

import sys
import math
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

# 루트가 아닐 때 갱신 (보통은 루트면 반환하고 갱신)
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

N = int(input())
parent = [i for i in range(N+1)]
stars = []
edges = []

for _ in range(N):
    x, y = map(float, input().split())
    stars.append((x, y))

# 별들 간 간선, 비용 계산 저장
for i in range(N - 1):
    for j in range(i+1, N):
        edges.append((math.sqrt((stars[i][0] - stars[j][0])**2 + (stars[i][1] - stars[j][1])**2), i, j))
    
edges.sort()

result = 0
for cost, start, end in edges:
    if union(start, end):
        result += cost

print(round(result, 2))
