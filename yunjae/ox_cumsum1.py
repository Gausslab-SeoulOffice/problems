# 백준 8958: OX퀴즈
# 문제 출처: https://www.acmicpc.net/problem/8958

# 풀이1: 스택 활용
def ox_cumsum(line):
  stack = []
  ans = 0

  for i in range(len(line)):
    if line[i] == 'O':
      stack.append(line[i])
      ans += len(stack)

    elif stack and line[i] == 'X':
      stack = []
  
    else:
      continue

  return ans

lines = [input() for _ in range(int(input()))]

for line in lines:
  print(ox_cumsum(line))
