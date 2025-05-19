# 프로그래머스 - 로봇 충돌
# https://school.programmers.co.kr/learn/courses/30/lessons/340211
# 완전 탐색 문제. 발상은 간단하지만 인덱싱에 주의.
# defaultdict에 이동 좌표를 저장한 다음 Counter로 층돌 횟수를 집계합니다

from collections import defaultdict, Counter

def solution(points, routes):
    answer = 0
    dic = defaultdict(list) # 충돌 횟수 파악을 위한 defaultdict
    
    # routes의 길이는 로봇의 개수이므로, 각 로봇을 이동
    for route in routes:
        path = []
        time = 0
        
        # 각 로봇이 이동한 (x, y) 좌표를 defaultdict에 저장 
        for i in range(1, len(route)):
            dept_x, dept_y = points[route[i-1]-1][0], points[route[i-1]-1][1] # 각 시작점 (1-based idx to 0-based)
            arvl_x, arvl_y = points[route[i]-1][0], points[route[i]-1][1] # 각 도착점
    
            if i == 1:
                dic[time].append((dept_x, dept_y))
        
            # x축 방향으로 한 칸씩 이동
            while dept_x != arvl_x:
                if dept_x < arvl_x:
                    dept_x += 1
                else:
                    dept_x -= 1
                time += 1
                dic[time].append((dept_x, dept_y))

            # y축 방향으로 한 칸씩 이동
            while dept_y != arvl_y:
                if dept_y < arvl_y:
                    dept_y += 1
                else:
                    dept_y -= 1
                time += 1
                dic[time].append((dept_x, dept_y))            
        
    # 각 time step별 충돌 횟수 파악
    # 만약 각 시점에서 저장된 좌표가 2개 이상이면 충돌이 일어난 것
    for key in dic:
        c = Counter(dic[key])
        for k in c:
            if c[k] > 1:
                answer += 1
            
    return answer
