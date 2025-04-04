# 프로그래머스 - 조이스틱
# https://school.programmers.co.kr/learn/courses/30/lessons/42860
# 그리디 알고리즘 문제인데 생각할 게 많음.
# 1) 가로로 조이스틱을 조작하는 횟수
# 1) 세로로 조이스틱을 조작하는 횟수
# 를 따로 생각해서 풀어야 함.
# 인터넷에 풀이가 많이 올라와 있지만 새로 test case가 추가되면서 실패하는 경우가 많습니다.
# 모든 case를 통과한 코드를 찾아 참고하여 정리했습니다.

def solution(name):
    if set(name) == {'A'}:     # 이 방법은 문자열이 특정 문자로만 이루어졌는지 체크할 때 유용함
        return 0

    # ASCII 인덱스
    a_idx = ord('A')           # 65          
    z_idx = ord('Z')           # 90

    answer = float('inf')      # 최소값을 구하기에 앞서 초기값 설정

    # 연속한 A들의 인덱스를 파악해서 그 전까지 포인터를 옮겨 푼다는 사람도 있는데, 그러면 'JABCAD' 같은 문자열 처리가 애매해진다
    # 조이스틱을 가로로 조작하는 두 가지 경우를 고려해서, 그때그때 문자열을 복사+재구성해보자.
    # 1-1) 직진: 특정 인덱스에서 시작해 계속 오른쪽으로만 갈 경우
    # 1-2) 꺾기: 특정 인덱스에서 시작해 오른쪽으로 가다 끝에서 멈추고, 다시 좌측으로 가는 경우
    
    # 문자열 복사 및 슬라이싱을 위한 for-loop
    for i in range(len(name)//2 + 1):         # 주어진 문자열 절반까지만 순회함
        forward = name[-i:] + name[:-i]         # i=3 이고 name='JOYSTICK'이면, name[-i] = 'I'이므로 'ICK' + 'JOYST'
        backward = name[i::-1] + name[i+1:][::-1]     # 위와 같은 경우, name[i] = 'S'이므로 'SYOJ' + 'KCIT'

        strings = [forward, backward]

        # 본격적인 조이스틱 조작 횟수 계산을 위한 for-loop
        for s in strings:
            while s and s[-1] == 'A':               # 끝의(trailing) A는 필요가 없다. while문이므로 연속된 A도 함께 처리된다
                s = s[:-1]

            ver_costs = [min(ord(char) - a_idx, (z_idx+1) - ord(char)) for char in s]     # A를 잘라낸 문자열 s 내에서 각 알파벳에 대한 세로 조이스틱 조작 횟수
            ver_cost = sum(ver_costs)                                                     # 문자열 s에 대한 전체 세로 조이스틱 조작 횟수
            hor_cost = i + (len(ver_costs)-1)                                             # 처음 시작 위치 i에서 조이스틱 가로 조작 횟수 + A를 잘라낸 뒤의 문자열 s에서 조이스틱 가로 조작 횟수
            tot_cost = hor_cost + ver_cost                                                # 합산

            answer = min(answer, tot_cost)                                                # 최소값 갱신
                              
    return answer
