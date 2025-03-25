# 백준 1927: 최소 힙
# https://www.acmicpc.net/problem/1927
# 크루스칼-프림 복습에 앞서 준비운동으로 구현합니다.
# 파이썬은 heapq 모듈을 지원합니다.

import sys
import = sys.stdin.readline

import heapq

N = int(input())
heap = []

for _ in range(N):
  command = int(input())

  if not command:
    if not heap:
      print(heapq.heappop(heap))

  if command:
    heapq.heappush(heap, command)
