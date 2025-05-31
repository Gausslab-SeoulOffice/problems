# 백준 1715 - 카드 정렬하기
# https://www.acmicpc.net/problem/1715
# 힙을 활용하는 문제

import sys
input = sys.stdin.readline

from heapq import heapify, heappush, heappop

N = int(input())

cards = [int(input()) for _ in range(N)]
heapify(cards)                              # 카드뭉치 모음을 힙 자료구조로 변환(heapify)

ans = 0

while len(cards) > 1:                       # 카드뭉치들이 하나로 모일 때까지
    tmp = heappop(cards) + heappop(cards)   # 가장 작은 뭉치 두 개를 뽑아서 더하고(heappop)
    heappush(cards, tmp)                    # 다시 카드뭉치 모음에 넣기(heappush)
    ans += tmp                              # 비교한만큼 정답에 더하기

print(ans)
