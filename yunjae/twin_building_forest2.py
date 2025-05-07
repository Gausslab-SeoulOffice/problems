# 프로그래머스 - 쌍둥이 빌딩 숲
# https://school.programmers.co.kr/learn/courses/30/lessons/140105
# 재귀를 이용한 풀이로 다시 풀

import sys
sys.setrecursionlimit(10**7)

MAX = 1000000007
dp = [[-1] * 101 for _ in range(101)]

for i in range(1, 101):
    dp[i][i] = 1  # 빌딩이 모두 보이게 하는 경우는 하나뿐이다
    dp[i][0] = 0  # 빌딩이 하나도 보이지 않는 경우는 없다

def solution(n, count):
    if dp[n][count] != -1:
        return dp[n][count]
    dp[n][count] = (solution(n-1,count-1) + solution(n-1,count) * 2* (n-1)) % MAX 
    
    return dp[n][count]
