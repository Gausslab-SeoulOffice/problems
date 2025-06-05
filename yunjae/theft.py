# 프로그래머스 - 도둑질
# https://school.programmers.co.kr/learn/courses/30/lessons/42897

# DP를 사용하는 문제이지만, 주어진 제약사항에 주의해야 한다
# 원형 구조 때문에, 첫 집을 털면 마지막 집은 못 턴다. 반대로 첫 집을 안 털면 마지막 집을 턴다.

# 따라서 두 가지 경우로 나누어서 생각한다.
# 1) 첫 집을 턴 경우: 마지막 집은 못 터므로 범위는 0 ~ n-2
# 2) 첫 집을 안 털고 두 번째 집부터 시작한 경우: 마지막 집까지 가능하므로 범위는 1 ~ n - 1

def solution(money):    
    # first: 첫 집을 터는 경우
    # last: 첫 집을 안 터는 경우
    first, last = [0] * len(money), [0] * len(money)
    
    # Case 1 초기화: 첫째 집부터
    # 두 번째 집은 털 수 없으므로, 금액을 money[0]으로 똑같이 유지
    first[0], first[1] = money[0], money[0] 
    for i in range(2, len(money)-1):
        first[i] = max(first[i-1], first[i-2]+money[i]) # max(i번째 안 텀, 두 집 떨어져 i번째 텀)

    # Case 2 초기화: 두 번째 집부터
    last[1] = money[1]   # 이제는 털 수 있으므로 금액을 새로 업데이트
    for i in range(2, len(money)):
        last[i] = max(last[i-1], last[i-2]+money[i])
    
    answer = max(first[-2], last[-1])  # max(Case 1의 마지막 고려 가능한 집, Case 2의 마지막 고려 가능한 집)
    
    return answer
