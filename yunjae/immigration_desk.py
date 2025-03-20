# 프로그래머스 - 입국심사
# https://school.programmers.co.kr/learn/courses/30/lessons/43238

# 제한시간(mid)에 각 심사관이 몇 명을 면접할 수 있는지 일일이 구해서 누적합하고, 그 수가 n과 들어맞을 때까지 제한시간(mid) 갱신을 반복한다.
# 최단 제한시간은 여기서 min(times)로 잡았다. 그 미만으로 시간이 걸리는 일은 불가능하기 때문이다. 이래야 불필요한 iteration이 줄어든다.

def solution(n, times):
    lower_bound, upper_bound = min(times), max(times)*n

    # 만약 upper_bound = mid - 1을 쓸 거라면, 종료조건은 lower_bound > upper_bound이므로 while lower_bound <= upper_bound로 써야 한다.
    # 최소값이나 최대값만 찾을 목적이라면 upper_bound = mid가 더 직관적이다. (이 문제의 경우) left를 답으로 바로 리턴하기 때문.
    # 후보값을 찾아 배열에 저장할 목적이라면 upper_bound = mid - 1이 더 직관적이다. answer 변수를 별도로 쓸 거라면 이 방법이 일반적.
    while lower_bound < upper_bound:
        mid = (lower_bound + upper_bound) // 2
        if sum(mid // time for time in times) >= n:
            upper_bound = mid  
        else:
            lower_bound = mid + 1
    return lower_bound
