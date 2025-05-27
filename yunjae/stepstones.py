# 프로그래머스 - 징검다리 건너기
# https://school.programmers.co.kr/learn/courses/30/lessons/64062
# k 크기의 구간들로부터 각각 최댓값을 구한 뒤 그 중 최솟값을 구하면 정답.
# 하지만 구간마다 max연산을 하면 시간초과가 나므로 최대힙을 사용한다
# (다음번에는 이분탐색으로도 풀어볼 것)

import heapq as hq
from math import inf

def solution(stones, k):
    Q = []
    answer = inf
    
    # k-2만큼 최대힙에 넣는다
    for i in range(k-1):
        hq.heappush(Q, (-stones[i], i))
    
    # k-1 이상은 최대힙에 넣되
    # 최대힙 맨 앞 인덱스가 i-k+1보다 같거나 커야 한다
    for i in range(k-1, len(stones)):
        hq.heappush(Q, (-stones[i], i))
        while Q[0][1] < i-k+1:
            hq.heappop(Q)
        answer = min(answer, -Q[0][0])
    
    return answer
    
