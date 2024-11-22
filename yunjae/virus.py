import sys
input = sys.stdin.readline

from collections import deque

V = int(input())  # 그래프 노드의 숫자
E = int(input())  # 그래프 간선의 숫

adj_list = [[] for _ in range(V + 1)] # 빈 인접 리스트

# 인접리스트로 값 입력 (간선 숫자만큼 돌면서 간선 정보 입력받아 인접 리스트에 입력한다)
for _ in range(E):
  start, end = map(int, input().split())
  adj_list[start].append(end) # 양방향 그래프이므로
  adj_list[end].append(start)

stack = [1] # 첫째 컴퓨터에서부터 시작하므로 스택에 넣고 시작
visited = set([1]) # 이미 방문했음을 담아줄 set (리스트를 쓰면 시간복잡도 O(N), set은 O(1))
infected = 0

# DFS
while stack:
  current = stack.pop() # 현 시점에서 방문할 컴퓨터를 하나 뽑는다 
  if current not in visited: # 아직 방문하지 않았다면
    visited.add(current) # 방문 처리한다
    infected += 1 # 감염되었다
  
  for next in adj_list[current]:
    if next not in visited: # 갈 수 있고 방문하지 않았다면
      stack.append(next) # 다음 갈 곳을 stack에 저장

print(infected-1) 
