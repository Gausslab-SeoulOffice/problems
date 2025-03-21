# 프로그래머스 - 더 맵게 (Lv. 2)
# https://school.programmers.co.kr/learn/courses/30/lessons/42626

# 값이 순서대로 정렬되어 있고, 그 값을 업데이트해야 할 때는 힙 자료형이 가장 좋다
# 이진탐색을 쓸 경우 트리의 상한선과 하한선을 찾기가 까다로워 효율성 점수에서 감점된다
# 힙을 쓴다면 그냥 heappush를 써 주면 된다

# 파이썬의 heapq 자료형은 최소힙이니까, 이 문제에서는 그대로 쓰면 된다

import heapq

def solution(scoville, K):
    heap = scoville[:]       # 원본 리스트 내용을 바꾸지 않도록 복사
    heapq.heapify(heap)

    answer = 0                # 최소 배합 횟수

    while len(heap) > 1:      # 원소가 두 개 이상 있어야 혼합이 되니까
        min_scvl = heapq.heappop(heap)
        if min_scvl >= K:
            break
        new_scvl = min_scvl + heapq.heappop(heap)*2

        heapq.heappush(heap, new_scvl)
        answer += 1
    
    return answer if heap[0] >= K else -1
