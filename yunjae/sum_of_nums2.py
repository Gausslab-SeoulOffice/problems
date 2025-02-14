# 조건문 중첩을 좀 줄이려면 이렇게 풀면 된다.
# 사실 나는 이 풀이가 더 직관적이고 논리적으로도 엄밀해 보인다.

import sys
input = sys.stdin.readline

N, M = map(int, input().split())
A = list(map(int, input().split()))

l, r = 0, 1
cnt = 0

while r <= N and l <= r: # r이 인덱스 범위를 넘지 않고, 구간 내에 포함된 값이 0개가 되기 전까지
  ans = sum(A[l:r])

  if ans == M:
    cnt += 1
    r += 1

  elif ans < M:
    r += 1

  else:
    l += 1

print(cnt)
