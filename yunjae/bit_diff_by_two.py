# 프로그래머스 - 2개 이하로 다른 비트
# https://school.programmers.co.kr/learn/courses/30/lessons/77885

# 짝수: 1을 더한다.
# 홀수: 오른쪽 끝에서부터 읽었을 때 가장 먼저 나오는 0과 그 뒤의 비트를 변경한다. (이 규칙성 찾기가 쉽지 않았다)
# 주의) 맨 왼쪽의 1을 0으로 바꾸어야 할 수도 있으니, 이진수 문자열 맨 왼쪽에 0을 하나 덧대 준다.

def solution(numbers):
    answer = []

    for n in numbers:
        if n % 2 == 0:
            answer.append(n + 1)
        else:
            b = '0' + format(n, 'b')
            for i in range(len(b)-1, -1, -1):
                if b[i] == '0':
                    answer.append(int(b[:i] + '10' + b[i+2:], 2))
                    break
    return answer
