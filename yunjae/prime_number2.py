# 프로그래머스 - 소수 찾기
# https://school.programmers.co.kr/learn/courses/30/lessons/42839
# 2) permutations 라이브러리를 이용한다

from itertools import permutations

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
    cand = set()                                # 중복된 숫자 조합은 필요없기 때문에 set 자료형을 쓴다

    # 개별 숫자 분리하기
    for r in range(1, len(numbers)+1):
        for p in permutations(numbers, r):      # numbers로부터 digit을 r개 뽑아
            num = int(''.join(p))               # 그걸로 임의의 숫자 조합을 만들어 정수로 변환
            cand.add(num)

    return sum(1 for num in cand if isPrime(num))
