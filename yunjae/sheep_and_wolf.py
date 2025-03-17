# 프로그래머스 - 양과 늑대 (2022 카카오 블라인드 채용)
# https://school.programmers.co.kr/learn/courses/30/lessons/92343

def solution(info, edges):
    visited = [0] * len(info) # 방문한 노드들 기록
    answer = []

    # 여기서는 DFS를 사용한다.
    # 물론 그냥 DFS대로만 갔다간 양이 잡아먹히겠지만, 
    # 문제를 읽어보면 기본적으로 최대한 깊이 탐색해야 함을 알 수 있다.
  
    # DFS는 재귀로도 구현 가능하다.
    # 탐색해 들어갈수록 양의 수를 누적시킬 것이므로 재귀가 적합하다.
  
    # 원래는 인접리스트나 인접행렬 등으로 바꿔야 할 텐데 그러면 info의 인덱스와 align되지 않는다.
    # edges에서는 [부모 노드 인덱스, 자식 노드 인덱스] 순의 입력이 반복된다.
    # 이 정보를 이용해서 이진트리를 순회할 것이다.
  
    def dfs(sheep, wolf):  # root가 무조건 양이라는 건, dfs(1, 0)에서부터 시작하면 된다는 뜻
        if sheep > wolf:
            answer.append(sheep)
        else:                   # 양이 머릿수에서 밀린다면
            return                # 그 길은 더 이상 탐색하지 않는다

        for p, c in edges:
            if visited[p] and not visited[c]:
                visited[c] = 1
                if info[c] == 0:        # 가야 할 자식 노드가 양이라면
                    dfs(sheep + 1, wolf)
                else:                   # 가야 할 자식 노드가 늑대라면
                    dfs(sheep, wolf + 1)
                visited[c] = 0          # 여러 번에 걸쳐 탐색시킬 것이므로 visited는 초기화한다.

    visited[0] = 1
    dfs(1, 0)

    return max(answer)
