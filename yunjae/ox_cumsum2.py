# 백준 8958: OX퀴즈
# 문제 출처: https://www.acmicpc.net/problem/8958

# 풀이2: Pythonic
def ox_cumsum(line):
  ans = 0
  tokens = [t for t in line.split('X') if t!='']  # X만 빼고, O로 이뤄진 토큰들만 집계
  
  if not tokens:
    return 0
  else:
    for token in tokens:
      ans += sum(range(1, len(token)+1)) # 리스트를 별도로 만들지 않고, 이렇게 range를 이용해서 누적합을 구해도 됨
  return ans

lines = [input() for _ in range(int(input()))]

for line in lines:
  print(ox_cumsum(line))
