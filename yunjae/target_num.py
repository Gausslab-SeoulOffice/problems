# 프로그래머스 - 타겟 넘버
# https://school.programmers.co.kr/learn/courses/30/lessons/43165
# BFS를 이용한 풀이(DFS로도 가능하나, 한번 찾은 깊이를 계속 반복해서 찾아야 되는 점이 비효율적)

# 이진트리를 직접 그리기보다, 그냥 노드 번호와 값만 부여해서 주어진 리스트를 순회하는 경우가 많다.
# 다양한 경우를 접해보는 것밖에 방법이 없는 듯
from collections import deque

def solution(numbers, target):
    answer = 0
    # (idx, val)
    Q = deque([(0, 0)])

    while Q:
        idx, val = Q.popleft()
        if idx < len(numbers):
            Q.append((idx+1, val + numbers[idx]))
            Q.append((idx+1, val - numbers[idx]))  
        else:
            if val == target:
                answer += 1
    return answer
