# 프로그래머스 - N으로 표현
# https://school.programmers.co.kr/learn/courses/30/lessons/42895
# DP 연습 문제입니다. 집합 자료형을 이용해서 풉니다.

def solution(N, number):
    if N == number:
        return 1
    
    answer = -1
    
    # DP list
    dp = [set() for s in range(9)]

    # DP list 초기화
    # 각 단계별 set마다 기본 수 str(N)*i로 초기화
    # (예: N=5일 때, dp[0] = {5}, dp[1] = {55}, dp[2] = {555} ...) 
    # enumerate()에서는 start= 매개변수를 설정할 수 있다
    for i, s in enumerate(dp, start=1):
        s.add(int(str(N)*i))
    
    # dp는 다음과 같이 구성된다.
    # { 
    #   "n" * i ∪ 
    #   dp[0] ⊗ dp[n-1] ∪
    #   dp[1] ⊗ dp[n-2] ∪
    #   ...
    #   dp[n-1] ⊗ dp[0] 
    # }
    # 여기서 dp[i]를 만드는 데 필요한 조합은
    # dp[0] ⊗ dp[i-1]
    # dp[1] ⊗ dp[i-2]
    # ...
    # dp[i-1] ⊗ dp[0]
    # number를 가장 최소값이 되게 하려면?
    for i in range(1, 9):
        for j in range(i):    # 앞서의 이유로, i가 1~9면 j는 0~i-1 까지
            for num1 in dp[j]:
                for num2 in dp[i-1-j]:
                    dp[i].add(num1 + num2)
                    dp[i].add(num1 - num2)
                    dp[i].add(num1 * num2)
                    if num2:
                        dp[i].add(num1 // num2)

        if number in dp[i]:  # s마다의 연산 단계 번호 i + 1를 반환
            return i + 1
    return answer
