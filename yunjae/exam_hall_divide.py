# 프로그래머스 - 시험장 나누기(2021 카카오 채용연계형 인턴십)
# https://school.programmers.co.kr/learn/courses/30/lessons/81305

# 레벨 5에 해당하는 문제인데, 프로그래머스에서 풀 수 있는 이진트리 문제가 많지 않아서 일단 건드려봤습니다.
# DP 등 다양한 접근법이 있지만, 여기서는 루트노드 찾기 + 이분탐색(+DFS)을 통해 접근하는 방식을 썼습니다.
# 다음번에는 혼자 힘으로 풀 수 있도록, (제 기준에서) 최대한 직관적인 풀이로 잘 정리해두는 게 목표였습니다.

import sys
sys.setrecursionlimit(int(1e6))

# 1) 루트노드의 인덱스를 찾는 함수
# 만약 set(집합)을 활용한다면 아래와 같이 구현 가능.
def find_root(links):
    # 1) 전체 노드를 구한다: 이 문제에서는 range()함수를 써서 구할 수 있다
    num_nodes = len(links)
    all_nodes = set(range(num_nodes))

    # 1) non-root 노드만 구한다: links를 flatten한 뒤 -1을 제외
    child_nodes = set()
    for node in links:
        for leaf in node:
            if leaf != -1:
                child_nodes.add(leaf)

    # 3) 2)에서 1)을 차집합하면 루트노드로 이뤄진 set만 남는다
    root_candidates = all_nodes - child_nodes

    # 4) set 자료형의 원소에 접근하려면 list(set)[0]보다 next(iter(set))이 메모리 효율이 좋다,
    ### 리스트를 새로 생성할 필요도 없고,
    ### O(1)의 시간 복잡도로 iterable한 자료형인 set의 첫째 원소에 접근 가능하니까. 
    return next(iter(root_candidates))

# 위의 코드를 아래처럼 고쳐쓰는 사람도 있다
# def find_root(links):
#     parents = {leaf for node in links for leaf in node if leaf != -1}
#     return next(i for i in range(len(links)) if i not in parents)


# 2-1) 이분탐색과 함께 활용할 함수
### DFS 탐색을 하면서 실질적인 계산이 수행되는 함수다.
### 아래 함수 활용된 파라미터 중에서
### - node는 재귀적 DFS에 필요
### - target, num, links는 조건 검증에 필요
def dfs(node, target, num, links):
    # 재귀 종료 조건
    if node == -1:
        return 0, 0
    # links에 들어 있는 노드 정보를 tuple unpacking을 통해 flatten
    left, right = links[node]

    # 재귀 탐색해서 (자르는 횟수, target value) 쌍을 구한다
    # left_value, right_value에는 각각 왼쪽/오른쪽 서브트리 노드들에 담긴 값의 총합이 재귀적으로 누적되어 저장된다
    left_count, left_value = dfs(left, target, num, links)
    right_count, right_value = dfs(right, target, num, links)
    both_count = left_count + right_count

    # candidate sum을 target 값과 비교
    cand_sum = left_value + right_value + num[node]

    # 현재 노드를 root로 삼는 subtree 전체가 valid subtree인 경우
    if cand_sum <= target:                                              
        return both_count, cand_sum

    # 트리를 아래의 둘로 분할해야 하는 경우
    # 1) 현재 노드 + 그 밑의 왼쪽/오른쪽 subtree,
    # 2) 오른쪽/왼쪽 subtree
    if min(left_value, right_value) + num[node] <= target:                  
        return both_count + 1, min(left_value, right_value) + num[node]     # 따라서 한 번 더 분할(both_count + 1)
    return both_count + 2, num[node]                                      # 합이 모두 target을 초과함: 두 subtree를 다 분리해야. 분할 횟수는 both_count + 2

# 2) 이분탐색 함수 
### 활용된 파라미터 중에서
### - root, start, end는 이진트리에서의 재귀적 이분탐색에 필요
### - k, num, links는 조건 검증에 필요
def binary_search(root, start, end, k, num, links):
    # 더 이상 mid값을 탐색할 만한 구간이 남아있지 않다면 재귀 종료
    if start > end:
        return start
    
    # 얼마만큼을 target 값의 초기값으로 삼을 것인가? -> [start. end], 즉 가능한 부분합 구간의 중간값.
    mid = (start + end) // 2
    div_times, _ = dfs(root, mid, num, links)

    # k개의 서브트리를 얻으려면, 자르는 횟수가 k - 1번이 필요하기 때문에 k - 1과 div_times를 비교한다
    # 우리는 최소의 div_times으로 얻을 수 있는 구간합 
    if div_times > k - 1:                                           # 너무 잘게 자른 경우: 즉, 이 mid 값은 쓸 수 없다
        return binary_search(root, mid + 1, end, k, num, links)     # 구간을 좀더 좁혀서 새로운 mid 값을 찾아 보자
    else:                                                           # 적당히 큼지막하게 자른 경우: 더 크게 자를 수는 없을까 체크가 필요하다.
        return binary_search(root, start, mid - 1, k, num, links)   # 구간을 좀더 좁혀서 새로운 mid 값을 찾아 보자

def solution(k, num, links):
    # 1. 루트노드 찾기
    ### DFS로 풀 수도 있고, 차집합으로 풀 수도 있다 (여기서는 후자)
    root = find_root(links)

    # 2. 이분탐색
    ### 주어진 k-1 이내에 최대 x의 크기로 절단할 수 있는 최소값 구하기
    ### [num의 최대값, num의 총합] 만큼의 범위에서 x값을 이분탐색 시작한다.
    ### 왜 num의 최대값을 lower bound로 삼는가?: 그래야 여러 노드의 값을 포함시킬 수 있기 때문이다.
    ### 왜 num의 총합을 upper bound로 삼는가?: 트리가 subtree로 나눠지지 않는 경우가 생길 수 있기 때문이다.
    answer = binary_search(root, max(num), sum(num), k, num, links)
    
    return answer
