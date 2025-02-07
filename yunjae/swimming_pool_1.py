# SWEA 1952번 수영장
# 문제 링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpFQaAQMDFAUq& (문제 열람 시 회원가입 필요)

# 방법1: backtracking 및 재귀
# 이 방법으로 풀면 시간복잡도가 O(3^12) - 달수가 고정되어있다고는 하지만 효율적이지 못하다 (재귀가 대부분 그렇다)

# acc: accumulated sum
def find_cheapest(month, acc):
  global answer

  # backtracking (유망한 값이 아니면 그냥 제거)
  if acc >= answer:
    return

  # 재귀 exit 조건
  if month > 11: # 12월까지 모두 구매하거나 범위를 넘어갈 경우
    if answer > acc: # 1년권보다 더 싼 누적값이 존재한다면
      answer = acc # 그 값으로 확정
    return
  
  # 1일권 수영장 plan 수만큼 사서 다음달로 재귀
  find_cheapest(month+1, acc+plans[month]*prices[0])

  # 1달권 사서 다음달로 재귀
  find_cheapest(month+1, acc+prices[1])

  # 3달권 사서 다음달로 재귀
  find_cheapest(month+3, acc+prices[2])

# 입출력부
T = int(input())

for tc in range(1, T+1): # tc: test case
  prices = list(map(int, input().split())) # 수영장 이용권 가격들
  plans = list(map(int, input().split())) # 12개월에 걸친 이용 계획
  answer = prices[3] # 일단 값을 1년권 기준으로 잡는다 (가장 값을 구하기 쉬우니까)
  find_cheapest(0, 0)

  print(f"#{tc}, {answer}")
