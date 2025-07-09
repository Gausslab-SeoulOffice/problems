# 백준 1010 - 다리 놓기
# https://www.acmicpc.net/problem/1010
# 조합 아니면 DP로 푸는 문제다.
# 이번에는 이항계수를 이용한 풀이. sum()을 이용한 풀이보다 간편하고 코드도 짧다.

MAX = 31 # M과 N의 최대값
dp = [[0]*MAX for _ in range(MAX)]

# 초기화
for n in range(MAX):
    dp[n][0] = 1    # n개 중 아무것도 고르지 않는 경우의 수는 단 하나
    dp[n][n] = 1    # n개 중 n개를 모두 고르는 경우의 수는 단 하나

# DP로 이항계수 채우기 (유명한 점화식임)
for n in range(1, MAX):
    for k in range(1, n):
        dp[n][k] = dp[n-1][k-1] + dp[n-1][k]
    
# 테스트케이스 처리
for _ in range(int(input())):
    N, M = map(int, input().split())
    print(dp[M][N])
