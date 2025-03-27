# 프로그래머스 - 공원 산책
# https://school.programmers.co.kr/learn/courses/30/lessons/172928
# 델타 탐색 연습용 Lv.1 문제.
# 주의할 점은, 경로 이동 중하나라도 조건이 맞지 않는다면 갱신하지 않아야 한다는 점

def solution(park, routes):
    delta = {
        'N': (-1, 0),
        'S': (1, 0),
        'W': (0, -1),
        'E': (0, 1)
    }
    N, M = len(park), len(park[0])
    
    # 출발지점 찾기
    for i in range(N):
        for j in range(M):
            if park[i][j] == 'S':
                y, x = i, j
                break

    for r in routes:
        ori, dist = r.split()
        dy, dx = delta[ori]
        dist = int(dist)
        
        
        # 경로 이동 중 하나라도 조건이 맞지 않는다면 갱신하지 않을 때 all()을 쓰면 편함
        # 만약 for 루프 없이 한꺼번에 dy * dist 해버리면, 중간 지점들을 거치지 않고 그냥 펄쩍 건너뛰는 효과이므로 에러가 남
        path = [(y + dy * step, x + dx * step) for step in range(1, dist+1)]
        if all(0 <= ny < N and 0 <= nx < M and park[ny][nx] != 'X' for ny, nx in path):
            y, x = path[-1]
        
        # 위 세 줄의 코드는 다음과 동일한 효과
#         ny, nx = y, x
#         valid_move = True
        
#         for _ in range(dist):
#             ny += dy
#             nx += dx
#             if not (0 <= ny < N and 0 <= nx < M) or (park[ny][nx] == 'X'):
#                 valid_move = False
#                 break        
        
#         if valid_move:
#             y, x = ny, nx

    return [y, x]
