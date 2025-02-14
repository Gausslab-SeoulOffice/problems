# 엄청 긴 입력을 받을 때 시간을 단축시키기 위함
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
A = list(map(int, input().split()))

# two-pointer로 풀어보자
# 배열의 길이는 N으로 고정되어 있지만,
# 구간합을 찾는 데 얼마나 오래 순회해야 할지 모르므로 while문을 쓴다

l, r = 0, 0
cnt = 0 # 각 구간합을 저장하여 M과 비교하는 용도
ans = 0 # 구간합의 경우의 수를 집계

while True:
  # 오른쪽 끝 인덱스(r)을 오른쪽으로 이동시켜 구간을 넓혀 나간다.
  # 그리고 구간합이 M이 될 때까지 계속 더해 본다.
  if cnt < M:
    if r < N:
      cnt += A[r]
      r += 1
    else: # 아직 M보다 작은데 더 더할 게 없으면?
      break # 반복 종료

  # 구간합이 M을 넘어간다면, 왼쪽 끝 인덱스(l)를 오른쪽으로 이동시켜 구간을 좁혀 나간다.
  # M에 도달하도록 다시 빼 준다
  elif cnt > M:
    cnt -= A[l]
    l += 1

  # 구간합이 M이 되었다면, 그때마다 경우의 수에 집계한다
  # 경우의 수 중복 집계의 가능성을 차단하기 위해, 왼쪽 혹은 오른쪽 인덱스를 하나씩 이동시켜 또다른 구간합을 구해 나간다
  if cnt == M:
    ans += 1
    cnt -= A[l] # 아니면 cnt -= A[r]
    l += 1 # 아니면 r += 1

print(cnt)
