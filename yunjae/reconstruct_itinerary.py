# LeetCode 332 - Reconstruct Itinerary
# https://leetcode.com/problems/reconstruct-itinerary/
# 그래프, DFS, Postorder, 스택 활용

from collections import defaultdict

class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        # 그래프 구현 (정렬한 후 append; 출발지의 도착지 리스트는 사전순의 역순으로 정렬)
        graph = defaultdict(list)
        for start, end in sorted(tickets, reverse=True):
            graph[start].append(end)
        
        route = []

        def dfs(start):
            # element를 하나씩 꺼낸다 (역순 정렬해 끝에서 뽑으므로 시간 효율이 좋다)
            while graph[start]:
                dfs(graph[start].pop())
            route.append(start) # 더 갈 곳이 없으면 그 노드를 경로에 추가(postorder)
        
        dfs('JFK')

        return route[::-1]   # postorder는 실제 방문 순서의 역순이므로, 출력은 뒤집어야
