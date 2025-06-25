# 백준 9663 - N-Queen
# https://www.acmicpc.net/problem/9663
# 8-Queen 문제로 유명한 예제입니다. 배열최소합 문제에 대각선 검토가 추가됨.

import sys
input = sys.stdin.readline

N = int(input())
answer = 0

# 초기 세팅
# 2*N - 1: 대각선의 최대 개수
check_vertical = [False] * N                # 상하 체크
check_diag_left = [False] * (2 * N - 1)     # 좌상~우하(↘) 대각선 체크 (행-열이 같으면 같은 대각선)
check_diag_right = [False] * (2 * N - 1)    # 우상~좌하(↙) 대각선 체크 (행+열이 같으면 같은 대각선)

def n_queen(depth):
    global answer
    
    # 방문
    if depth == N:                          # 기저 사례: depth가 N까지 도달하면 성공으로 집계
        answer += 1
        return

    # 현재 행에서 열 i에 퀸을 둘 수 있나 판단함
    for i in range(N):
        # 상하 or 왼쪽 대각선 or 오른쪽 대각선에 퀸이 있다면, 패스
        if check_vertical[i] or check_diag_left[depth-i] or check_diag_right[depth+i]:
            continue
        # 퀸이 없다면, 현재 위치에 퀸을 둔다고 가정하고 방문 처리
        check_vertical[i] = True
        check_diag_left[depth-i] = True
        check_diag_right[depth+i] = True
        
        # 그 다음 줄로 재귀 이동하며 반복
        n_queen(depth + 1) 
        
        # 백트래킹: 해당 위치에 퀸을 둔 후 다음 줄에서 실패했다면 선택을 되돌림
        # 모든 경우를 탐색해야 하므로 반드시 undo
        check_vertical[i] = False
        check_diag_left[depth-i] = False
        check_diag_right[depth+i] = False
        
n_queen(0)
print(answer)
        
