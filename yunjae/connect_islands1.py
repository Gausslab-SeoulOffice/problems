# 프로그래머스 - 섬 연결하기
# https://school.programmers.co.kr/learn/courses/30/lessons/42861
# 풀이1. 정석 Kruskal

import sys
sys.setrecursionlimit(10**9)

def solution(n, costs):
    def find(x):
        if parent[x] != x:
            parent[x] = find(parent[x])
        return parent[x]
    
    def union(x, y):
        x_root, y_root = find(x), find(y)
        if x_root != y_root:
            parent[y_root] = x_root
            return True
        return False

    answer = 0
    parent = [i for i in range(n)]
    
    costs.sort(key=lambda x: x[2])
    
    for start, end, cost in costs:
        if union(start, end):
            answer += cost
    
    return answer
