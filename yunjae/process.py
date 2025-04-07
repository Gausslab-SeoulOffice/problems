# 프로그래머스 - 프로세스
# https://school.programmers.co.kr/learn/courses/30/lessons/42587
# 큐 연습용 문제입니다.
# 단, 원소의 인덱스 정보를 기억해야 하고, 원소의 값을 비교하여 append 여부를 판단해야 합니다.

from collections import deque

def solution(priorities, location):
    # 원소의 인덱스 정보를 보존해야 되므로 enumerate()를 쓰자
    Q = deque([(i, p) for i, p in enumerate(priorities)])
    ans = 0

    while Q:
        proc = Q.popleft()
        if any(proc[1] < q[1] for q in Q):
            Q.append(proc)
        else:
            ans += 1
            if proc[0] == location:
                return ans
