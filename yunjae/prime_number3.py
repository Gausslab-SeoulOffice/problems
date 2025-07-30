from math import sqrt

def solution(numbers):
    answer = 0
    result = set()
    
    # 숫자 조합을 생성하는 DFS
    def dfs(word, used):
        nonlocal numbers
        
        if word:
            result.add(int(word))
        
        # 아직 사용하지 않은 숫자를 선택해 word에 추가
        for i in range(len(numbers)):
            if not used[i]:
                used[i] = True
                dfs(word + numbers[i], used)
                used[i] = False  # 끝났으면 복구, 다음을 탐색
    
    numbers = list(numbers)
    dfs("", [False] * len(numbers))
    
    # 최대 숫자를 기준으로, 소수 판별
    max_num = max(result)
    is_prime = [False, False] + [True] * (max_num - 1) # 0과 1은 소수가 아니므로
    
    for i in range(2, int(sqrt(max_num)) + 1):
        if is_prime[i]:
            for j in range(i*i, max_num + 1, i):
                is_prime[j] = False
    
    # 소수 개수 집계
    answer = sum(1 for num in result if is_prime[num])
    
    return answer
    
