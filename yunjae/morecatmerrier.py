# 백준 27961 - 고양이는 많을수록 좋다
# https://www.acmicpc.net/problem/27961

# 지수함수를 이용한 효율적 알고리즘 (O(log n))

import sys
input = sys.stdin.readline

n = int(input())

if n == 0:
    print(0)
else:
    power = 1
    cnt = 0
    while power < n:  # 2의 거듭제곱 중 n보다 크거나 같은 최소값 찾기
        power *= 2
        cnt += 1      # 2배 연산을 한 횟수
    print(cnt + 1)  # 맨 처음에 1마리를 데려온 케이스도 포함
