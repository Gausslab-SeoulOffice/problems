# 백준 2661 - 좋은 수열
# https://www.acmicpc.net/problem/2661
# DFS + 문자열 대칭 확인

import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

def dfs(seq):
    global N
    if N == len(seq):
        print(seq)
        exit()
    for i in range(1, 4):  # 숫자 1, 2, 3으로만 이뤄져 있으므로
        if is_asymmetrical(seq + str(i)):
            dfs(seq + str(i))  # 덧붙이면 비대칭을 충족하는 숫자를 수열에 붙여가며 계속 탐색

# 나쁜 수열의 특징인 '부분 대칭 반복'을 금지하기 위해 검사
# i길이의 마지막 부분 수열인 seq[-i:]가, 바로 그 앞의 i길이 수열 seq[-2i:-i]와 같은지 검사
def is_asymmetrical(seq):
    for i in range(1, len(seq)//2 + 1):
        if seq[-i:] == seq[-2*i:-i]:
            return False
    return True

N = int(input())
dfs('1')
