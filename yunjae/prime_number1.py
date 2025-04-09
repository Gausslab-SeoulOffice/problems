# 프로그래머스 - 소수 찾기
# https://school.programmers.co.kr/learn/courses/30/lessons/42839
# 완전 탐색 연습용 문제
# 1) 에라토스테네스의 체 + DFS로 푸는 방법

# 에라토스테네스의 체
def isPrime(n):
    if n < 2: # 0과 1은 소수가 아니다
        return False
    for i in range(2, n):
        if n % i == 0: # 약수가 하나라도 있다면 소수가 아니다 
            return False
    return True

def solution(numbers):
    answer = 0

    # 개별 숫자 분리하기
    arr = list(numbers)
    visited = [0]*len(numbers) # 이 경우는 parsed digit들끼리 중복될 수 있으므로 boolean indices를 그냥 쓴다
    candidates = set()

    # 가능한 숫자 조합을 모두 찾는다.
    # 순열로 찾는 방법도 있지만, 재귀 DFS를 활용해 보자. 
    # start는 빈 문자열부터.
    # 문자 길이가 k가 되는 경우 숫자 리스트에 담는다
    def dfs(S):
        nonlocal numbers
        if S:
            candidates.add(int(S))
        for i in range(len(numbers)):
            if visited[i] == 0:
                visited[i] = 1
                dfs(S + arr[i])
                visited[i] = 0 # 방문 여부 복구

    dfs('')

    # 소수인지 확인
    for c in candidates:
        if isPrime(c):
            answer += 1

    return answer
