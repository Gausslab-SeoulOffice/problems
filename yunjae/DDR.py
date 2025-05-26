# 백준 2342 - Dance Dance Revolution
# https://www.acmicpc.net/problem/2342
# DP로 해결 가능

import sys
input = sys.stdin.readline

N = list(map(int, input().split()))
N = N[:-1]                             # 마지막 0은 제거(종료 신호)
MAX = float('inf')

# 한 발(왼발/오른발)이 밟을 수 있는 발판의 가짓수는 총 5가지
# 최소값을 찾는 게 목적이기 때문에, MAX로 초기화
dp = [[[MAX for _ in range(5)] for _ in range(5)] for _ in range(len(N)+1)]
dp[0][0][0] = 0

# 발판의 시작점과 끝점에 따른 힘 계산 (Python은 case switch 못 씀)
def calc_dist(start, end):
    if start == 0:
        return 2
    elif start == end:
        return 1
    elif abs(end - start) == 2:
        return 4
    else:
        return 3

for i, nxt in enumerate(N):
    for l in range(5):
        for r in range(5):
            cost = dp[i][l][r]
            dp[i+1][nxt][r] = min(dp[i+1][nxt][r], cost + calc_dist(l, nxt)) # 왼발 이동
            dp[i+1][l][nxt] = min(dp[i+1][l][nxt], cost + calc_dist(r, nxt)) # 오른발 이동
    
# dp table의 맨 마지막 단계에서 모든 왼발/오른발 조합 중 최소
result = min(min(row) for row in dp[-1])

print(result)
