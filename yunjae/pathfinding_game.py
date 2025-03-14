# 프로그래머스: 길찾기 게임 (2019 카카오 블라인드 채용 문제)
# https://school.programmers.co.kr/learn/courses/30/lessons/42892

# 파이썬에서의 이진트리 구현과 관련된 문제를 찾다가, 가장 보편적이고 직관적인 풀이를 익힌다는 생각으로 본 문제를 선택함.

import sys
sys.setrecursionlimit(10**6) # 재귀 시 시간초과 방지를 위해

# 이번 문제는 좌표평면에 트리를 그려야 한다
# 노드들로 이뤄진 리스트를 이진으로 분할하며 각 노드가 있어야 할 위치를 찾아나갈 것이다
def divide_nodes(nodes, y):
    for i, node in enumerate(nodes):
        if y == node[2]:
            return nodes[:i], nodes[i+1:]

def solution(nodeinfo):
    # 재귀함수 정의 (트리만들기 + 순회를 동시에)
    def make_tree(nodes):

        # 재귀 종료 조건
        if not nodes:
            return

        n, x, y = max(nodes, key=lambda x:x[2]) # 먼저 루트노드를 찾자. y좌표가 가장 큰 노드가 루트노드다 

        x_sorted_nodes = sorted(nodes, key=lambda x:x[1])   # 노드를 x좌표에 대해 정렬하여, 좌표평면에 뿌려준다
                                                            # 같은 높이(y좌표)상에서 x좌표의 값에 따라 노드의 위치가 결정되기 때문

        preord_list.append(n)  # 전위순회
        l_nodes, r_nodes = divide_nodes(x_sorted_nodes, y) # 루트를 기준으로 노드들 분할
        make_tree(l_nodes)
        make_tree(r_nodes)
        postord_list.append(n) # 후위순회
    
    nodes = [(i+1, node[0], node[1]) for i, node in enumerate(nodeinfo)] # (node에 담길 값, x좌표, y좌표)
    preord_list = []
    postord_list = []

    # 재귀 실행
    make_tree(nodes)
    
    answer = [preord_list, postord_list]

    return answer
