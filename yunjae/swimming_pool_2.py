# SWEA 1952번 수영장
# 상향식 DP를 이용한 풀이
# 이렇게 풀면 O(12)가 되어 시간복잡도 절약

T = int(input())

for tc in range(1, T+1):
  prices = list(map(int, input().split())) # 수영장 이용권 가격들
  plans = list(map(int, input().split())) # 12개월에 걸친 이용 계획

  INF = float('inf')
  dp = [INF] * 13 # 최소가격을 구하기 위한 DP table
  dp[0] = 0 # 처음 값은 0에서 시작

  for i in range(12):
    if dp[i] == INF:
      continue # skip unreachable months

    # 이전 최소값을 carry forward
    dp[i+1] = min(dp[i+1], dp[i]+ plans[i] * prices[0]) # 1일권
    dp[i+1] = min(dp[i+1], dp[i] + prices[1]) # 1달권
    if i + 3 <= 12: # out of range 에러를 막기 위함
      dp[i+3] = min(dp[i+3], dp[i]+prices[2])
  
  answer = min(dp[12], prices[3]) # 1년권 값과 비교하여 최소값을 구한다
  print(f"#{tc}, {answer}")
