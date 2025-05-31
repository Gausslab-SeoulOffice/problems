# 프로그래머스 - 리코쳇 로봇
# https://school.programmers.co.kr/learn/courses/30/lessons/169199
# 기존 BFS와 다른 점은 board를 벗어나거나 D를 만날 때까지 쭉 이동해야 한다는 것.

from collections import deque

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

def solution(board):
    N, M = len(board), len(board[0])
    Q = deque()
    visited = set()
    
    # 시작점(R)을 찾는다
    for y in range(N):
        for x in range(M):
            if board[y][x] == 'R':
                Q.append((y, x, 0))
                visited.add((y, x))
                break
    
    # BFS
    while Q:
        y, x, moves = Q.popleft()
        
        # 도착지면 BFS 종료
        if board[y][x] == 'G':
            return moves

        # 델타탐색
        for i in range(4):
            ny, nx = y, x
            # 한 번 델타탐색 때마다 직진할 수 있을 때까지 직진
            while 0 <= ny + dy[i] < N and 0 <= nx + dx[i] < M and board[ny + dy[i]][nx + dx[i]] != 'D':
                ny, nx = ny + dy[i], nx + dx[i]
            
            # 직진한 끝에 막다른 위치만 visited에 남김
            if (ny, nx) not in visited:
                visited.add((ny, nx))
                Q.append((ny, nx, moves+1))    
    return -1
