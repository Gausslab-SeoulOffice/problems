# 프로그래머스 크레인 인형뽑기게임 (2019년 카카오 겨울 인턴십 기출)
# https://school.programmers.co.kr/learn/courses/30/lessons/64061
# 스택을 활용한다.

def solution(board, moves):
    result = 0
    stack = []
    lanes = [[] for i in range(len(board))]
    
    # 각 라인은 스택이 아니기 때문에, 스택으로 변형시키는 것이 중요
    # 그래서 lanes에 복사한다
    for i in range(len(board), 0, -1):
        for j in range(len(board)):
            if board[i-1][j] == 0:
                continue
            lanes[j].append(board[i-1][j])

    for i in moves:
        if len(lanes[i-1]) == 0:
            continue
        stack.append(lanes[i-1].pop())
        if len(stack) > 1:
            # 스택 맨 위의 2개가 서로 같으면 펑
            if stack[-1] == stack[-2]:
                stack.pop()
                stack.pop()
                result += 2

    return result
