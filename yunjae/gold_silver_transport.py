# 프로그래머스 - 금과 은 운반
# https://school.programmers.co.kr/learn/courses/30/lessons/86053
# 이분탐색

def solution(a, b, g, s, w, t):
    start = 0
    answer = end = (10**9) * (10**5) * 4  # 소요시간의 worst case: 광물 최대무게 * 금과 은 * 도시 최대 개수 * 왕복
    
    while start <= end:
        mid = (start + end) // 2    # 주어진 배달 시간 갱신
        gold = silver = total = 0
        
        # 도시별 계산
        for i in range(len(g)):
            # 현재 정보
            cur_gold, cur_silver, cur_weight, cur_time = g[i], s[i], w[i], t[i]
            
            move_cnt = mid // (cur_time * 2)  # 각 도시에서 mid 시간 내에 왕복 가능한 횟수
            # 아직 편도 한 번 더 갈 수 있다면, 편도 추가
            if mid % (cur_time * 2) >= cur_time:
                move_cnt += 1
            
            # 각 도시로 보낼 수 있는 자원의 양
            gold += min(cur_gold, move_cnt * cur_weight) 
            silver += min(cur_silver, move_cnt * cur_weight)
            total += min(cur_gold + cur_silver, move_cnt * cur_weight)
        
        # 이분탐색
        # 금을 a이상, 은을 b이상 보냈다면 거의 다 된 것. 좀더 시간 절약을 할 수 있는지 알아보면 됨
        if gold >= a and silver >= b and total >= a + b:
            answer = min(answer, mid)
            end = mid - 1            
        # 아직 금과 은을 각각 a, b만큼 못 보낸다면 시간이 부족하다는 뜻. 좀더 소요시간을 넉넉하게 줘 보자
        else:
            start = mid + 1
        
    return answer
