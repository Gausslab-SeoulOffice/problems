# 백준 6523 - 요세푸스 한 번 더!
# https://www.acmicpc.net/submit/6523/96679483
# 해시테이블

import sys
input = sys.stdin.readline

def generate_seq(N, a, b):
    x = 0            # 수열 시작값
    count = {x: 1}   # 등장 숫자와 횟수 저장 (초기값은 {0: 1})
    
    while True:
        x = ((a * x) % N * (x % N) + b) % N   # 수열 생성식: (a * x * x + b) % N 을 modulo의 분배법칙으로 풀어쓴다
        count[x] = count.get(x, 0) + 1        # x가 없다면 default로 0을 get
        if count[x] == 3:
            break
        
    only_once = sum(1 for v in count.values() if v == 1)  # list.count(1)보다 메모리효율 좋다
    return N - len(count) + only_once

while True:
    line = input().strip()        # 공백 제거 안정성을 위해
    if not line or len(line.split()) == 1:
        break
    N, a, b = map(int, line.split())
    result = generate_seq(N, a, b)
    print(result)
