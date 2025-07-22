# 백준 1525 - 퍼즐
# https://www.acmicpc.net/problem/1525
# BFS를 이용한 풀이입니다 (퍼즐의 답이 정해져 있음에 주의)

import sys
from collections import deque
input = sys.stdin.readline

s = ''
goal = '123456780'     # 미리 정해진 퀴즈 답

# 현재 상태의 퍼즐을 문자열 키로
puzzle = []
for i in range(3):
    puzzle += list(sys.stdin.readline().rstrip().split())
puzzle = ''.join(puzzle)

Q = deque()
Q.append([puzzle, 0])
visited = set()
visited.add(puzzle)        # 방문 여부를 문자열 키의 집합 내 존재 여부로 판단

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

while Q:
    cur_puzzle, cur_cnt = Q.popleft()
    
    if cur_puzzle == goal:
        break
    
    zero_idx = cur_puzzle.find('0')
    row, col = divmod(zero_idx, 3)              # 0이 위치한 1차원 인덱스를 2차원 좌표로 변환

    # 델타 탐색
    for x, y in zip(dx, dy):
        nxt_row, nxt_col = row + y, col + x
        if nxt_row < 0 or nxt_col < 0 or nxt_row >= 3 or nxt_col >= 3:
            continue
        
        # 조각의 위치를 옮긴 퍼즐 상태를 생성하기
        nxt_idx = nxt_row * 3 + nxt_col        # 좌표를 1차원 인덱스로 복원
        nxt_puzzle = list(cur_puzzle)
        nxt_puzzle[nxt_idx], nxt_puzzle[zero_idx] = nxt_puzzle[zero_idx], nxt_puzzle[nxt_idx]
        nxt_puzzle = ''.join(nxt_puzzle)       # 조각의 위치를 옮긴 퍼즐을 다시 문자열 키로
        
        # 새 상태가 처음 보는 경우에만 방문 처리하고 큐에 추가
        if not nxt_puzzle in visited:
            visited.add(nxt_puzzle)
            Q.append([nxt_puzzle, cur_cnt + 1])

# 목표 상태에 도달했다면 정답 출력            
if cur_puzzle == goal:
    print(cur_cnt)
else:
    print(-1)
