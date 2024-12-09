def solution(progresses, speeds):
    queue = []
    answer = []
    days = 0

    # 각 공정별 추가 경과일을 저장하는 queue를 구현한다
    for i in range(len(speeds)):
        if (100 - progresses[i]) % speeds[i] < speeds[i] and (100 - progresses[i]) % speeds[i] != 0:
            days = 1
        days += (100 - progresses[i]) // speeds[i]
        queue.append(days)
        days = 0

    now = 0 # 누적의 기준일을 기억할 변수 now가 필요하다
    for i in range(len(queue)):
        if queue[i] > queue[now]:
            answer.append(i - now)
            now = i
    answer.append(len(queue) - now) # 맨 마지막

    return answer
