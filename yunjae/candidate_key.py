# 프로그래머스 - 후보키 (2019 카카오 공채 기출)
# https://school.programmers.co.kr/learn/courses/30/lessons/42890

# 비트마스킹을 통해 풀 수 있는 문제인데, 파이썬 풀이를 찾아보기 어려워 이번 기회에 풀이 정리했습니다.

# 예시 input - 6 rows, 4 columns
# relation = [
#     ["100", "ryan", "music", "2"],
#     ["200", "apeach", "math", "2"],
#     ["300", "tube", "computer", "3"],
#     ["400", "con", "computer", "4"],
#     ["500", "muzi", "music", "3"],
#     ["600", "apeach", "music", "2"]
# ]

def solution(relation):
    row_len, col_len = len(relation), len(relation[0])
    result = []

    # 인덱스 번호를 이진수로 바꾸면, 각 열에 대응되는 boolean처럼 쓸 수 있다
    # 1 = 0001 = {0} (ID)
    # 2 = 0010 = {1} (name)
    # 3 = 0011 = {0, 1} (ID, name)
    # 4 = 0100 = {2} (Major)
    # ...
    # 16 = 1111 = {0, 1, 2, 3} (All)
  
    for i in range(1, 1 << col_len):                        # 모든 열 조합의 부분집합을 체크한다
        if not is_minimal(i, result):                       # 1) 해당 열 조합은 최소 집합인가?
            continue
        if not is_unique(i, relation, row_len, col_len):    # 2) 해당 열 조합은 모든 열을 
            continue
        result.append(i)

    return len(result)

def is_minimal(bitmask, result):
    for key in result:
        # 키 조합(bitmask)에 이미 기존의 후보 키가 포함되어 있다면, 해당 키 조합은 최소 집합이 아니므로 False
        # [0]이라는 키가 이미 result에 있다면,
        # [0, 1]은 [0]을 포함하므로 최소성을 충족하지 못한다.
        if (bitmask & key) == key:
            return False
    return True

def is_unique(bitmask, relation, row_len, col_len):
    seen = set()  

    # 키 조합(bitmask)이 나타내는 인덱스 번호들 (예: 0110 (6) → [1, 2])
    ## 2진수를 한자리씩 오른쪽으로 shift하며, if문에서 다음과 같이 체크한다. 
    ## (0111 & 0001)=0001 -> 1과 &한 결과가 1이므로 0번 인덱스가 부분집합에 포함되어 있다
    ## (0011 & 0001)=0001 -> 1번 인덱스 is in 부분집합
    ## (0001 & 0001)=0001 -> 2번 인덱스 is in 부분집합
    ## (0000 & 0001)=0000 -> 3번 인덱스 is not in 부분집합
    indices = [i for i in range(col_len) if (bitmask >> i) & 1]   

    for row in relation:
        key = tuple(row[i] for i in indices) # 예: 0110 (6) → (row[1], row[2])
        if key in seen:
            return False
        seen.add(key)  # 예: {..., (row[1], row[2]), ...}
    return True
