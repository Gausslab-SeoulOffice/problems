# 백준 15654: N과 M(5)
# https://www.acmicpc.net/problem/15654

import sys
input = sys.stdin.readline

# 재귀 구현 연습
# 입력부터 받는다
n, m = map(int, input().split())
numbers = list(map(int, input().split())) # 아니면 [int(x) for x in input().split()]
numbers.sort() # 정렬

def perm(depth):
  # 재귀 탈출 조건
  if depth == m:
    print(*ans) # 리스트 앞의 *은 unpacking 역할을 한다. 아니면 print(' '.join(map(str, ans)))
    return
  
  # 빈 리스트나 0으로 초기화된 정답 리스트에 숫자를 넣어줌
  # 빈 리스트라면 append하고, 0의 리스트라면 인덱싱
  # (여기서는 append를 사용해보겠음)
  for i in range(n):
    # 중복 방지를 위해
    if numbers[i] in ans:
      continue
    ans.append(numbers[i])
    perm(depth + 1)
    ans.pop()

ans = []
perm(0)
