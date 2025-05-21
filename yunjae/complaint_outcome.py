# 프로그래머스 - 신고 결과 받기
# https://school.programmers.co.kr/learn/courses/30/lessons/92334
# 사용자별 신고당한 횟수를 저장 시, 기본값이 0으로 세팅된 defaultdict를 이용해서 코드를 간소화

from collections import defaultdict

def solution(id_list, report, k):
    answer = []
    
    report = list(set(report)) # 중복 신고 제거
    user = defaultdict(set)
    cnt = defaultdict(int) # 사용자별 신고당한 횟수
    
    for r in report:
        reporter, reported = r.split()
        user[reporter].add(reported)    # 신고자-피신고자 업데이트
        cnt[reported] += 1              # 신고당한 횟수 업데이트

    # 메일을 보낸 횟수 저장
    for i in id_list:
        result = 0
        for u in user[i]:
            if cnt[u] >= k:
                result += 1
        answer.append(result)
    
    return answer
