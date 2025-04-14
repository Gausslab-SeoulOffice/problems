# 프로그래머스 - 광물 캐기
# https://school.programmers.co.kr/learn/courses/30/lessons/172927
# DFS로 완전탐색하는 풀이도 있지만 시간초과가 뜬다
# 따라서 여기서는 Greedy로 풀자

from collections import Counter

def solution(picks, minerals):
    answer = 0

    # 1) 캘 수 있는 광물들만큼만 남긴다
    # 캘 수 있는 광물 수를 파악하는 방식이 구현한 사람마다 꽤나 다르다
    # 여기서는 곡괭이로 캘 수 있는 광물의 수보다 광물 순서(minerals)의 길이가 더 길 경우만 별개로 생각함
    # 나머지 경우에는 원래배열 minerals를 그냥 유지
    if len(minerals) > 5 * sum(picks):
        minerals = minerals[:5 * sum(picks)]

    # 2) minerals를 5개씩 끊어서 그 안에 있는 광물 개수를 각각 파악한다.
    # for문을 돌리는 방법도 있지만 Counter를 쓰면 편하다
    costs = []
    for i in range(0, len(minerals), 5):
        cnt = Counter(minerals[i:i+5])
        costs.append((cnt['diamond'], cnt['iron'], cnt['stone']))
        
    # 3) 내림차순 정렬 (Greedy 준비)
    costs.sort(reverse=True)

    # 4) 캐기 (Greedy: 가장 좋은 곡괭이로, 앞에서부터 최대한 많이 쳐낸다)
    for d, i, s in costs:
        if picks[0]:              # 다이아몬드 곡괭이가 있다면
            answer += d + i + s
            picks[0] -= 1
        elif picks[1]:
            answer += d*5 + i + s
            picks[1] -= 1
        elif picks[2]:
            answer += d*25 + i*5 + s  
            picks[2] -= 1
    
    return answer
