# 백준 28358 - 생일 맞추기
# https://www.acmicpc.net/problem/28358
# 태어난 해가 윤년임을 고려
# 풀이1. brute-force (가장 직관적)

# 1. 월별로 마지막 날 매핑
m_days = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

# 2. 생일에 들어갈 수 없는 수 파악
banned = [list(map(int, input().split())) for _ in range(int(input()))]

def is_valid(x, banned):
  for digit in str(x):
    if banned[int(digit)]:
      return False
  return True

# 3. 가능한 월별로 가능한 일자 조합의 수 구하기
for _ in range(len(banned)):
  cnt = 0
  for month in range(1, 12):
    for day in range(1, m_days[month]+1):
      if is_valid(month, banned) and is_valid(day, banned):
        cnt += 1
    print(cnt)
