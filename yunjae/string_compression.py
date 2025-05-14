# 프로그래머스 - 문자열 압축
# https://school.programmers.co.kr/learn/courses/30/lessons/60057
# 완전 탐색 문제이지만, 문자열을 직접 압축할 필요 없다.
# 단위 길이별로 반복되는 문자열만 파악한 후 공식을 적용하면 빠르게 풀 수 있다.
# 새 문자열 길이 = 기존 길이 - (반복 횟수 * 문자열 자르는 단위) + 문자열 자르는 단위 + 반복 횟수를 표현한 길이

# 예) 
# abcabcabcabcdededededede
# 4개 단위로 자른다면 dede만 3번 반복된다. 따라서 새 문자열: abcabcabcabc3dede
# 이 경우, 문자열 자르는 단위: 3; 반복 횟수를 표현한 길이: 1

# 문자열을 자르는 단위의 범위: 1에서 len(s) // 2 까지


def solution(s):
    min_len = len(s) # 문자열 길이 최소값 초기화
    str_len = len(s)
    
    for unit in range(1, (len(s)//2)+1):
        prev_word = ""
        new_len = str_len       # 매 단위마다 원래 문자열 길이로 초기화
        count = 1
        
        for start_idx in range(0, str_len, unit):
            if start_idx + unit > str_len:  # 문자열 거의 끝까지 왔다면 그만둠
                break

            target = s[start_idx:start_idx + unit]

            if target == prev_word:   # 이전 문자와 반복되는 경우
                count += 1
            elif count > 1:  # 이전 문자와 다르며, 반복 카운트가 1보다 크면, 
                             # 문자열이 압축된다고 판단하고서 새로운 문자열 길이 계산
                new_len = new_len - (count * unit) + unit + len(str(count)) # 공식 적용
                count = 1

            prev_word = target  # 현재 단어를 다음 비교를 위한 기준(이전 단어)으로 설정
        
        if count > 1:  # 반복문이 끝난 후, 마지막 반복 문자열 그룹에 대해 압축 처리
            new_len = new_len - (count * unit) + unit + len(str(count))
    
        min_len = min(min_len, new_len)  # 문자열 길이 최소값 갱신
    
    return min_len
