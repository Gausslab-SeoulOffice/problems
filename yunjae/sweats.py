# 프로그래머스 - 체육복
# https://school.programmers.co.kr/learn/courses/30/lessons/42862
# 그리디 알고리즘 연습문제입니다.
# 대부분은 여벌 옷이 도난당한 경우를 제거하기 위해 for문을 쓰는데 여기서는 차집합을 썼습니다.

def solution(n, lost, reserve):
    # 미리 정렬해줌 (안 해주면 결과가 다르게 나온다)
    lost.sort()
    reserve.sort()
    
    # 여벌 옷이 도난당한 경우를 제거
    # 차집합을 통해 구현
    new_lost = set(lost) - set(reserve)
    new_reserve = set(reserve) - set(lost)

    # 그리디 (여벌옷을 고를 때는 뒤보다 앞 번호를 최우선시)
    for i in new_lost:
        if i - 1 in new_reserve:
            new_reserve.remove(i - 1)
        elif i + 1 in new_reserve:
            new_reserve.remove(i + 1)
        else:                           # 빌려줄 체육복이 없다면
            n -= 1                      # 전체 학생에서 1 뺀다
    
    return n
