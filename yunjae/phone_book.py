# 프로그래머스 - 전화번호 목록
# https://school.programmers.co.kr/learn/courses/30/lessons/42577
# 저는 startswith()을 사용해서 풀었지만 풀이법이 다양한 문제입니다.

def solution(phone_book):
    ans = sorted(phone_book)
    for i in range(len(ans)-1):
        if ans[i+1].startswith(ans[i]):
            return False
    return True
