# 프로그래머스 - 큰 수 만들기
# https://school.programmers.co.kr/learn/courses/30/lessons/42883
# 그리디 알고리즘 연습용 (Lv. 2)

def solution(number, k):
    stack = []
    i = 0
    
    # 스택 맨 위의 값이 새로 넣을 값보다 작을 때마다 pop
    for n in number:
        while stack and i < k and stack[-1] < n:    # 처음에는 if문으로 시도해봤지만, 그러면 4177252841의 경우 맨 앞의 4를 제거하지 못함
            stack.pop()
            i += 1
        stack.append(n)
          
    answer = ''.join(stack)
    return answer[:len(answer) - (k-i)]  # k-i > 0인 경우가 있을 수 있기 때문에, 스택 최상위에 담긴 작은 수들을 제외해주면 가장 큰 수를 만들 수 있다.
