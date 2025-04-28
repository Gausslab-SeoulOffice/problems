# 프로그래머스 - 표 편집
# https://school.programmers.co.kr/learn/courses/30/lessons/81303
# 연결 리스트 자료형과 메소드를 문제풀이에 필요한 만큼만 구현하여 풀이
# 리스트를 연결리스트처럼 써서 풀이하는 것보다 직관적이어서 좋음 (단, 사전에 구현 연습이 되어있어야)

class Node:
    def __init__(self, idx):
        self.idx = idx
        self.prev = None
        self.next = None

class LinkedList:
    def __init__(self, n):
        self.nodes = [Node(i) for i in range(n)]
        for i in range(1, n):
            self.nodes[i].prev = self.nodes[i-1]
            self.nodes[i-1].next = self.nodes[i]

    def move(self, node, count, direction):
        for _ in range(count):
            node = node.next if direction == 'D' else node.prev
        return node

    def remove(self, node):
        prev_node = node.prev
        next_node = node.next
        if prev_node:
            prev_node.next = next_node
        if next_node:
            next_node.prev = prev_node
        return (prev_node, node, next_node)       # pop같은 효과

    def restore(self, prev_node, node, next_node):
        if prev_node:
            prev_node.next = node
        if next_node:
            next_node.prev = node
        node.prev = prev_node
        node.next = next_node

def solution(n, k, cmd):
    del_stack = []
    answer = ['O'] * n

    linked_list = LinkedList(n)  # n개의 노드로 구성된 연결 리스트를 만든다
    now = linked_list.nodes[k]   # 커서 now는 현재의 k번째 노드를 가리킨다

    for c in cmd:
        if c[0] == 'C':
            del_stack.append(linked_list.remove(now))
            answer[now.idx] = 'X'
            now = now.next if now.next else now.prev
        elif c[0] == 'Z':
            prev_node, node, next_node = del_stack.pop()
            linked_list.restore(prev_node, node, next_node)
            answer[node.idx] = 'O'
        else:
            direction, count = c.split()
            now = linked_list.move(now, int(count), direction)
    
    return ''.join(answer)
