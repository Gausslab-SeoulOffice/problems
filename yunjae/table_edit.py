# 프로그래머스: 표 편집
# https://school.programmers.co.kr/learn/courses/30/lessons/81303

# 테이블을 구현한 뒤 일일이 pop, insert하다 보면(나도 처음 풀 때 이랬다) 효율성 점수에서 감점된다
# 별도의 테이블 구현 없이 인덱스만 이용해 푸는 방법을 주로 권장하는데,
# up 인덱스 배열과 down 인덱스 배열을 따로 정의하고 푸는 방법도 있지만
# 여기서는 좀더 간결하게 연결리스트를 활용한다

# 코딩테스트에서는 가급적 자료형을 직접 구현하기보다,
# 파이썬이 제공하는 자료형을 최대한 재활용해서 내가 원하는 자료형을 구현하는 편이 시간상 유리하다
# 여기서는 연결리스트를 딕셔너리로 구현해 보겠다 (형태는 {idx: [prev_idx, next_idx]})

def solution(n, k, cmd):
    del_stack = [] # 삭제된 가장 최근 원소들을 저장해둘 stack
    now = k
    answer = ['O'] * n

    # 인덱스로 구성된 연결리스트 구현 (다른 문제 푸는 데도 써먹을 수 있다)
    table = {i:[i-1, i+1] for i in range(n)}
    table[0] = [None, 1]
    table[n-1] = [n-2, None]

    for c in cmd:
        if c == "C":
            answer[now] = 'X'
            prev, next = table[now]
            del_stack.append([prev, now, next])

            # 기존 노드간 연결 끊고 재설정
            if next == None:                # 삭제된 노드가 마지막 노드라면(다음 노드가 없다면)
                now = prev                  # 삭제된 노드의 직전 노드(prev)를 현재로 삼는다
                table[prev][1] = None       # prev의 다음 노드는 없으므로 None처리
            elif prev == None:              # 삭제된 노드가 첫번째 노드라면(이전 노드가 없다면)
                now = next                  # 삭제된 노드의 다음 노드(next)를 현재로 삼는다
                table[next][0] == None      # 그 다음 노드를 첫번째 노드로 임명해줘야 한다
            else:                           # 삭제된 노드가 처음도 끝도 아니라면(다음 노드가 있다면)
                now = next                  # 삭제된 노드 바로 다음을 현재로 삼는다
                table[prev][1] = next       # 연결 재설정
                table[next][0] = prev

        elif c == "Z":
            prev, idx, next = del_stack.pop()
            answer[idx] = 'O'
            if next==None:                  # 복원된 노드(now)가 마지막 노드라면
                table[prev][1] = idx        # 연결을 회복해 준다
            elif prev==None:                # 복원된 노드(now)가 첫번째 노드여도 마찬가지
                table[next][0] = idx
            else:                           # 복원된 노드가 처음도 끝도 아니더라도 마찬가지
                table[next][0] = idx
                table[prev][1] = idx

        # 커서 이동
        else:
            if c[0] == 'D':                 # 커서 이동 (down)
                for _ in range(int(c.split()[1])):
                    now = table[now][1]
            else:                           # 커서 이동 (up)
                for _ in range(int(c.split()[1])):
                    now = table[now][0]
        
    return ''.join(answer)
