# 프로그래머스 - 표현 가능한 이진트리 (2023 카카오 블라인드 채용)
# https://school.programmers.co.kr/learn/courses/30/lessons/150367
# 3단계로 나누어 접근해야 하는 문제.

# 3. 해당 문자열이 포화이진트리인지 아닌지 판단한다 (DFS 탐색 활용)
### - 포화 이진트리는 높이(depth)가 일정하다. 따라서 아래 개념을 재귀에 활용한다.
### - 포화이진트리 depth = (노드 개수+1) // 4
### - 이번 문제는 맨 왼쪽 노드에서부터 인덱스를 매기므로 다음과 같이 .
### - root 인덱스가 i일 때, 왼쪽 자식의 인덱스는 i - depth//2, 오른쪽 자식은 i + depth//2
def dfs(b, idx, depth):
    # leaf에 도달했으면 포화이진트리로 판정, 재귀 종료
    if depth == 0:
        return True   

    # 부모노드가 더미(0)일 때 왼쪽/오른쪽 자식노드가 1이면 이진트리가 아니다
    elif b[idx] == '0':
        if b[idx - depth] == '1' or b[idx + depth] == '1':  
            return False

    # 양쪽 서브트리 모두 포화이진트리여야 해당 트리를 포화이진트리로 판정
    left = dfs(b, idx - depth, depth // 2) 
    right = dfs(b, idx + depth, depth // 2)

    return left and right


def solution(numbers):
    answer = []
    for n in numbers:
        # 1. 주어진 수를 이진수로 만든 뒤 필요한 노드의 개수를 구한다
        ### bin()을 쓴다면 인덱스를 통해 슬라이싱을 해줘야 하는데 format()을 쓰면 간편하다 
        b = format(n, 'b')          

        # 2. 이진수를 포화이진트리 형태로 만든다 (이 부분이 어려움)
        ### b_len 이상이면서 가장 가까운 포화이진트리의 노드수를 찾아야 한다. 
        ### while 루프를 돌려서 푸는 사람도 있지만 효율이 떨어진다. 시간이 허락한다면 규칙성을 찾자.
        ### 이진트리를 만드는 데 필요한 노드 수: bin(b_len + 1)[2:]
        ### 위 공식은 math.ceil(math.log(n)) + 1과 같은 효과 (비트 연산이 훨씬 간결하다)
        num_nodes = format(len(b) + 1, 'b') # 포화이진트리의 노드 개수
    
        ### 포화 이진트리 문자열을 미리 구하고 싶다면: 1 << len(num_nodes)
        ### 위 공식은 2**(int(math.log(b_len)) + 1) - 1과 같은 효과
        if '1' in num_nodes[1:]:                              # 1을 더했는데 111.. 꼴이라면, 원래 값은 포화 이진트리가 아니라는 의미
            dummies = (1 << len(num_nodes)) - int(num_nodes, 2) # (주어진 이진수에서 가장 가까운 포화이진트리 - 주어진 이진수)
            b = '0' * dummies + b                               # 앞에서 구한 갯수만큼 더미노드(0)를 앞에 추가


        # 3. 포화 이진트리 여부 판정 (위 dfs 함수 정의부 참조)
        result = dfs(b, len(b)//2, (len(b)+1)//4)             # idx가 len(b)//2로 들어가는 건 루트에서부터 탐색하니까
        if result:
            answer.append(1)
        else:
            answer.append(0)

    return answer    
