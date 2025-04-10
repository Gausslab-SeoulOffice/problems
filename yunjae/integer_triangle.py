# 프로그래머스 - 정수 삼각형
# https://school.programmers.co.kr/learn/courses/30/lessons/43105
# DP를 이용해서 푸는 문제. 다음 두 가지 분기가 있을 수 있음에 주의
# 1) 양쪽 가장자리를 따라 내려간다면 별도의 비교 없이 누적합
# 2) 가장자리 이외의 경우, 바로 윗줄의 양쪽 누적곱을 비교하여 그 최댓값을 취해 누적합

def solution(triangle):
    for i in range(1, len(triangle)):
        for j in range(i+1):
            if j == 0:                                  # 왼쪽 가장자리
                triangle[i][j] += triangle[i-1][j]
            elif j == i:                                # 오른쪽 가장자리
                triangle[i][j] += triangle[i-1][j-1]
            else:                                       # 가장자리 이외 (삼각형 안쪽)
                triangle[i][j] += max(triangle[i-1][j-1], triangle[i-1][j])
    return max(triangle[-1])
