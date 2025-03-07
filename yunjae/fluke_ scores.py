# 프로그래머스: 모의고사
# https://school.programmers.co.kr/learn/courses/30/lessons/42840

# 찍어서 문제를 맞춘 사람들 중 가장 많은 문제를 맞춘 사람을 구하는 문제.

def solution(answers):
    patterns = [
        [1, 2, 3, 4, 5],                  # 1번 수포자의 찍기 패턴
        [2, 1, 2, 3, 2, 4, 2, 5],         # 2번 수포자의 찍기 패턴
		[3, 3, 1, 1, 2, 2, 4, 4, 5, 5]    # 3번 수포자의 찍기 패
    ]

    scores = [0] * 3       # 수포자 3명 점수 저장 리스트

    for i, answer in enumerate(answers):
        for j, pattern in enumerate(patterns):
            if answer == pattern[i % len(pattern)]:
                scores[j] += 1     # 맞은 점수를 누적해 기록

    max_score = max(scores)

    highest_scores = []
    for i, score in enumerate(scores):
        if score == max_score:    # 가장 높은 점수를 받은 사람이 여럿이라면
            highest_scores.append(i + 1)  # return 값을 오름차순 정렬하는 효과

    return highest_scores
