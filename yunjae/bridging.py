# 백준 1010 - 다리 놓기
# https://www.acmicpc.net/problem/1010
# 조합 아니면 DP로 푸는 문제다.
# DP로도 가능한 점화식이 두 가지 이상 있는데, 여기서는 그 중 하나로 풀어보자.

for _ in range(int(input())):
    N, M = map(int, input().split())
    
    dp = [[0 for _ in range(M+1)] for _ in range(N+1)]    # DP table
    dp[1] = [i for i in range(M+1)]                       # 초기값

    # 오른쪽에서 m번째를 마지막으로 사용할 경우, 그보다 작은 위치들에서 n-1개를 놓는 경우를 모두 더한다.
    # dp[n][m] = dp[n−1][m−1] + dp[n−1][m−2] + ... + dp[n−1][1]
    
    # dp[n][m] = 오른쪽에서 m까지의 위치 중, 마지막 다리를 m에 놓는 모든 경우의 수
    # 이때 그 앞쪽 위치인 m-1, m-2, ..., 1까지 중 하나를 이전 다리의 끝으로 삼아야 하므로,
    # 그 이전에 n - 1개의 다리를 놓은 경우를 모두 더하는 것.

    # 예) dp[2][4]를 계산할 경우, 마지막 다리를 4에 놓았다고 가정하고,
    # 이전 다리 1개는 1, 2, 3에 놓을 수 있으므로 dp[1][3], dp[1][2], dp[1][1]을 더한다.
    for n in range(2, N+1):
        for m in range(1, M+1):
            dp[n][m] = sum(dp[n-1][m-i] for i in range(1, m+1))
    
    print(dp[N][M])
