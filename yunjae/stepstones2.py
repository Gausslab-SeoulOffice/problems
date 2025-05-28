# 프로그래머스 - 징검다리 건너기
# https://school.programmers.co.kr/learn/courses/30/lessons/64062
# 이분탐색으로 다시 풀었다. (속도는 다소 느리지만 효율성까지 통과함)

def solution(stones, k):
    # 중간값이 mid인 상태에서 k개의 징검돌을 연이어 건넌다고 할 때,
    # 다 건너봐도 징검돌에 매겨진 숫자가 mid보다 적다면 건너기는 실패한다. 
    def can_cross(mid):
        consec = 0
        for stone in stones:
            if stone < mid:
                consec += 1
                if consec >= k:
                    return False
            else:
                consec = 0
        return True

    # left이상 right 이하만큼의 사람들이 건너는 데 실패한다
    left, right = 1, max(stones)
        
    while left <= right:
        mid = (left + right) // 2
        
        # 건널 수 있다면 right half로 범위를 좁혀 찾고
        # 건널 수 없다면 left half로 범위를 좁혀 찾는다
        if can_cross(mid):
            left = mid + 1
        else:
            right = mid - 1
    
    return left - 1 # 건널 수 있는 최대한의 사람 수
