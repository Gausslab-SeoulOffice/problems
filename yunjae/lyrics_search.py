# 프로그래머스 - 가사 검색
# https://school.programmers.co.kr/learn/courses/30/lessons/60060
# Trie를 이용해 풀어야 효율성 테스트를 통과할 수 있음

from collections import defaultdict

class TrieNode:
    def __init__(self):
        self.children = {}     # 예: o 노드의 children은 s, z, n 등이 될 수 있음
        self.count = 0         # 해당 노드를 몇 개의 단어가 거쳐가는지 저장

class Trie():
    def __init__(self):
        self.root = TrieNode()
        
    # 단어를 입력받아 한 글자씩 분할하여 Trie에 집어넣는다
    # 예) 문자열 fro를 insert한다고 하면 다음과 같이 nested한 모양이 된다
    # self.root = {
    #   'f': [ 
    #     {
    #        'r': [
    #             {
    #                 'o': [ {}, 1 ]
    #             },
    #             1
    #         ]
    #     },
    #     1
    #   ]
    # }
    def insert(self, word):
        node = self.root
        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()  
            node.count += 1              # count 증가
            node = node.children[char]   # 다음 노드로 이동

    # Trie 탐색 후 일치하는 단어 수를 반환한다
    def find(self, query):
        node = self.root
        for char in query:
            if char == "?":            # 이걸 만나면 순회를 멈추고, 
                return node.count      # 그 노드의 count(해당 노드를 거친 단어)를 반환
            if char not in node.children:  # 해당 단어가 없는 경우 그냥 0 리턴
                return 0
            node = node.children[char]      # 다음 노드로 이동
        return node.count               # 맨 끝까지 순회했을 경우의 count 반환

def solution(words, queries):
    ans = []

    # defaultdict 선언
    prefix_tries = defaultdict(Trie)
    suffix_tries = defaultdict(Trie)
    word_count_by_length = defaultdict(int)

    # 단어목록 defaultdict에 저장
    for word in words:
        prefix_tries[len(word)].insert(word)        # 주어진 길이에 해당하는 모든 문자열이 트리에 담긴다
        suffix_tries[len(word)].insert(word[::-1])  # 접미어 매칭 확인을 위해 문자열을 반전한다
        word_count_by_length[len(word)] += 1                   # 주어진 길이에 해당하는 모든 문자열의 개수

    # query 탐색
    for query in queries:
        if query[0] == "?" and query[-1] == "?":
            ans.append(word_count_by_length[len(query)])
        elif query[0] == "?":                      # ?로 시작한다면 fro??와 같이 suffix query
            ans.append(suffix_tries[len(query)].find(query[::-1]))
        elif query[-1] == "?":
            ans.append(prefix_tries[len(query)].find(query))
    return ans
