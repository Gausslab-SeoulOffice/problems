# 프로그래머스 - 불량 사용자 (2019 카카오 겨울 인턴십 기출)
# https://school.programmers.co.kr/learn/courses/30/lessons/64064

# DFS를 쓰되, 방문 표시를 bitmasking으로 구현하고 문자열 일치 체크에 정규표현식 활용

import re

def solution(user_id, banned_id):
    def is_match(user, banned):
        pattern = re.escape(banned).replace("\\*", ".")     # . 은 어떤 한 글자와도 일치하는 특수문자
        return bool(re.fullmatch(pattern, user))

    def dfs(idx, bit):        # i: ID 인덱스, bit: user_id의 사용 여부를 비트로 표현(bitmasking)하여 저장한 정수
        nonlocal len_u, len_b

        if idx == len_b:        # 불량 아이디 수만큼 재귀했다면 저장
            result.append(bit)
            return

        for i in range(len_u):
            if not bit & (1 << i) and is_match(user_id[i], banned_id[idx]):     # bit & (1 << i): i번 인덱스가 이미 bit에 마킹됐음
                dfs(idx + 1, bit | (1 << i))
        
    len_u, len_b = len(user_id), len(banned_id)
    result = []

    dfs(0, 0)

    return len(set(result)) # 다른 순서로 DFS했는데 bitmasking 결과는 같을 수가 있으므로 중복 제거
