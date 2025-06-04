# 프로그래머스 - 디펜스 게임
# https://school.programmers.co.kr/learn/courses/30/lessons/142085
# 이분탐색을 이용한 풀이

def solution(n, k, enemy):
    left, right = 0, len(enemy)
    
    while left <= right:
        mid = (left + right) // 2
        inv = k  # 무적권
        rounds = sorted(enemy[0:mid], reverse=True)
        total = 0
        
        for i in range(len(rounds)):
            if inv:
                inv -= 1
            else:
                total += rounds[i]
        
        if n - total >= 0 and k >= 1:  # 적들의 합이 내가 갖고 있는 병사보다 적거나, 무적권이 1개 이상 남았다면
            left = mid + 1   # 오른쪽 지역 탐색
        else:
            right = mid - 1  # 왼쪽 지역 탐색
    
    return left - 1
