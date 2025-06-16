# 프로그래머스 - 무지의 먹방 라이브
# https://school.programmers.co.kr/learn/courses/30/lessons/42891
# 우선순위 큐로 푸는 문제
# 단, 인덱스 및 시간 k의 갱신에 주의해서 풀어야 함

import heapq as hq

def solution(food_times, k):
    # 식사 시간이 k보다 작거나 같다면 -1
    if sum(food_times) <= k:
        return -1
    
    length = len(food_times)
    
    Q = []
    for i in range(length):
        hq.heappush(Q, (food_times[i], i+1))   # (음식 시간, 인덱스 번호)

    # prev: 이전 라운드에서 다 먹은 음식의 시간값
    # Q[0][0]: 음식 시간이 제일 적은 요리. 가장 적게 걸리는 음식 
    # (Q[0][0] - prev) * length: 남은 음식 전부가 한 라운드를 도는 데 걸리는 시간
    # 예: Q가 [(1, 2), (3, 1), (2, 3)]이라면
    # prev = 0일 때 가장 적은 음식 시간은 1이고 (1 - 0) * 3 = 3초 필요
    # k = 5에서 3만큼 차감하면 k = 2; length = 2; prev = 1
    # 다음 음식 시간은 2이며, (2 - 1) * 2 = 2초 필요. k -= 2 하고 나면 k = 0. 그 다음은 불가능
    # 원래 음식 번호 순서대로 되돌리기 위해 남은 음식을 정렬하면 [(3, 1)]
    # k % length: 이미 k초를 쓴 상태에서, 남은 length개의 음식을 번호 순서대로 나열했을 때 바로 이어서 먹게 될 음식
    # k % length = 0이므로 인덱스 0부터 다시 먹으면 됨. 정답은 1번 음식
    
    prev = 0    
    while (Q[0][0] - prev) * length < k:
        if k > (Q[0][0] - prev) * length:  
            k -= (Q[0][0] - prev) * length
            length -= 1
            prev, _ = hq.heappop(Q)
    
    result = sorted(Q, key=lambda x: x[1])
    return result[k % length][1]
