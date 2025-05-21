# 프로그래머스 - 과제 진행하기
# https://school.programmers.co.kr/learn/courses/30/lessons/176962
# 중간에 잠깐 과제를 멈췄다가 다시 해야 한다는 건 '기억'이 필요하다는 뜻
# 스택을 활용한다

def solution(plans):
    stack = []
    finished = []
    
    # 시각을 분 단위로 변환
    for i in range(len(plans)):
        hour, minute = map(int, plans[i][1].split(':'))
        plans[i][1] = hour*60 + minute
        plans[i][2] = int(plans[i][2])
    
    # 시각을 key로 하여 정렬
    plans = sorted(plans, key = lambda x: x[1])
    
    # finished 리스트에 값 추가
    for i in range(len(plans)):    
        cur = plans[i]              # 현재 [과목, 시각, 소요시간]
        nxt = plans[i+1] if i < len(plans) - 1 else 0  # 다음 [과목, 시각, 소요시간]

        # 1) 마지막 plan은 그냥 끝냄 처리
        if i == len(plans) - 1:    
            finished.append(cur[0])

        # 2) 현재 plan 마친 시간과 다음 plan 시작 시간 사이에 idle time이 있을 경우    
        elif cur[1] + cur[2] <= nxt[1]:
            idle = nxt[1] - (cur[1] + cur[2])
            finished.append(cur[0])
            
            # 중간에 멈춘 작업 처리
            while stack: 
                if stack[-1][2] <= idle: # idle time 동안 마무리가 가능한 경우
                    idle -= stack[-1][2]
                    finished.append(stack.pop()[0])
                else: # idle time 내에 다 못 끝낼 경우 
                    stack[-1][2] -= idle
                    break # stack은 비지 않았지만, 더 이상 중간에 멈춘 작업 처리가 불가능하므로 멈춤
                    
        # 3) idle time 없이, 다음 task에 의해 interrupt 되는 경우 
        else:
            cur[2] -= nxt[1] - cur[1] # 과제 푸는 데 걸리는 시간을 '풀다가 중간에 멈추고 마저 남은 시간'으로 업데이트
            stack.append(cur)
    
    # stack에 남은 일정 처리
    while stack:
        finished.append(stack.pop()[0])
    
    return finished
