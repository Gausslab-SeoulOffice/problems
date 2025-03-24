# 프로그래머스 - 이중 우선순위 큐
# https://school.programmers.co.kr/learn/courses/30/lessons/42628

# 우선순위 큐 자료형은 보통 힙으로 구현한다는 점을 알아야 빨리 풀 수 있다.
# 최댓값 삭제, 최솟값 삭제라는 두 가지 방향으로 연산을 해야 하므로 힙을 두 개(최소힙, 최대힙) 구현한다.
# 파이썬의 heapq는 최소힙이다. 만약 최대힙으로 구현하려면 - 부호를 붙여주면 된다.
# 원소를 제거할 때는 최소힙과 최대합에서 동시에 제거해주어야 한다.

import heapq

def solution(operations):
    minheap, maxheap = [], []

    for o in operations:
        inst, num = o.split(' ')
        if inst=='I':
            heapq.heappush(minheap, int(num))
            heapq.heappush(maxheap, -1*int(num))
        elif inst=='D' and num == '1':
            if maxheap:
                heapq.heappop(maxheap)
                minheap.pop()             # maxheap과 minheap의 pop 방향은 반대임에 유의
        elif inst=='D' and num == '-1':
            if maxheap:
                maxheap.pop()
                heapq.heappop(minheap)
    
    return [-1*heapq.heappop(maxheap), heapq.heappop(minheap)] if maxheap else [0, 0]
