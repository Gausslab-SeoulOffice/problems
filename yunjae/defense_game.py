# 프로그래머스 - 디펜스 게임
# https://school.programmers.co.kr/learn/courses/30/lessons/142085
# 우선순위큐나 이분탐색으로 풀 수 있는 문제 (여기서는 우선순위큐)

import heapq as hq

def solution(n, k, enemy):
    # 적을 다 무찌르고도 무적권이 남는 경우
    if k >= len(enemy):
        return len(enemy)
    
    pq = []
    
    for i in range(len(enemy)):
        hq.heappush(pq, enemy[i])

        # 무적권을 다 썼다면 병사를 하나씩 차감
        if len(pq) > k:
            last = hq.heappop(pq)
            if last > n:   # 더 이상 적을 무찌를 수 없다면
                return i   # i째 턴이 끝
            n -= last
    
    # 차감하고 나서도 아직 남은 병사가 있다면, 적을 다 무찌른 것
    return len(enemy)
