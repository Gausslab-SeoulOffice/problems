# 백준 28358 - 생일 맞추기
# https://www.acmicpc.net/problem/28358
# 2. 비트마스크 연산을 써서 속도를 향상시켜 보자.

m_days = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

# 숫자 x에 등장하는 각 숫자를 비트로 표현
# 예) 23 -> 1 << 2 | 1 << 3 -> 00001100
# 금지된 숫자와 겹치는지 확인하려면 & 연산자를 사용한다. & 결과가 0이 아니라면 겹치는 숫자가 있다는 뜻.

def to_digit_mask(x):
  mask = 0
  for digit in str(x):
    mask |= 1 << int(digit)
  return mask

for _ in range(int(input())):
  banned = list(map(int, input().split()))
  banned_mask = 0
  for i in range(10):
    if banned[i]:
      banned_mask |= 1 << i

  cnt = 0
  for month in range(1, 13):
    if to_digit_mask(month) & banned_mask:
      continue
    for day in range(1, m_days[month]+1):
      if to_digit_mask(day) & banned_mask:
        continue
      cnt += 1
  print(cnt)
