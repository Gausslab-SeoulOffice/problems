# 프로그래머스 - 양궁 대회
# https://school.programmers.co.kr/learn/courses/30/lessons/92342
# n: 어피치와 라이언이 각각 쏘는 화살의 개수
# info: 어피치의 과녁 점수

# 비트마스킹을 이용한다

def solution(n, info):
    answer = [0] * 11
    temp = [0] * 11         # 라이언이 몇 발을 쐈는지 임시 기록할 배열
    max_diff = 0
    
    for subset in range(1, 1 << 10):   # 1 ~ 1023 (총 10칸짜리 과녁)
        apeach, ryan, cnt = 0, 0, 0    # 어피치 점수, 라이언 점수, 쏜 화살 수
        for i in range(10):            # i=0이면 정중앙
            if subset & (1 << i):      # i번째 비트가 1인지 확인 (라이언이 해당 점수를 가져오려는 경우)
                ryan += 10 - i
                temp[i] = info[i] + 1  # 어피치가 info[i]발을 쐈으니, 라이언은 그보다 1발 더 쏴야 점수를 가져올 수 있음
                cnt += temp[i]         # 라이언이 지금까지 쏜 화살 수를 누적
            else:                      # 어피치가 이기거나 비기는 경우
                temp[i] = 0
                if info[i] > 0:
                    apeach += 10 - i
        
        if cnt > n:                    # 쏠 수 있는 화살 수를 초과하면 건너뜀
            continue
        
        temp[10] = n - cnt             # n발을 다 쏴야 하므로, 남은 화살은 모두 0점에 쏜다고 가정
        
        # 라이언이 가장 큰 점수차로 우승할 수 있는 방법이 여러 가지라면?
        if ryan - apeach > max_diff:       # 점수 차이가 현재까지의 최대보다 클 경우 최적이므로
            max_diff = ryan - apeach       # 갱신
            answer = temp.copy()           # 현재 조합을 정답으로 저장

        elif ryan - apeach == max_diff:     # 동점인 경우, 더 우선시되는 조합을 찾는다
            for i in reversed(range(11)):  # 가장 낮은 점수를 더 많이 맞힌 경우를 우선시, 내림차순 탐색
                if temp[i] > answer[i]:     # 현재 조합이 answer보다 더 많은 화살을 쏘므로 더 우선시되는 조합
                    answer = temp.copy()
                    break
                elif temp[i] < answer[i]:   # 덜 우선시되는 조합
                    break
    
    if max_diff == 0:   # 라이언의 점수가 어피치보다 낮거나 같으면 그냥 0으로 취급
        return [-1]

    return answer
