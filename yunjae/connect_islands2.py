# 프로그래머스 - 섬 연결하기
# https://school.programmers.co.kr/learn/courses/30/lessons/42861
# 풀이2. 간소화된 Kruskal

# 정석적인 풀이와는 다음과 같은 차이가 있음. (코테에서는 정석적인 풀이를 권장하는 편인 듯)
# 1) 사이클 판단: find(x) == find(y)가 아닌. visited 리스트로 단순 판단
#    -> (단점) 정점 start와 end가 서로 다른 연결 그룹에 있어도 사이클로 오판할 수 있음
# 2) 집합 병합: union(x, y)로 루트를 병합하지 않고, visited.append()로 방문 표시
#    -> (단점) 정점의 접속 여부만 추적할 뿐, 그 정점이 어느 집합에 소속됐는지는 모르므로 트리가 정확히 병합되지 않을 수 있음
# 3) 정점 연결 여부: 루트가 다를 때만 연결하지 않고, 하나라도 visited에 있으면 시도
# 4) 시간 복잡도: 정석은 O(E log V)가 걸리지만, 이 경우는 O(E * V)까지 가능해 비효율적

def solution(n, costs):
    answer = 0
    visited = [0]
    
    costs.sort(key=lambda x: x[2])
    
    while len(visited) < n:
        for start, end, cost in costs:
            if start in visited or end in visited:      # 시작점/끝점 중 하나라도 방문 리스트에 들어있을 때
                if start in visited and end in visited:   # 사이클이 발생하는 조건을 충족하면 건너뜀
                    continue
                else:                                     # 사이클이 발생하지 않을 경우 방문 표시
                    if start not in visited:
                        visited.append(start)
                    if end not in visited:
                        visited.append(end)
                    answer += cost
                    break                                 # 이미 연결됐으므로 루프 종료 후 다음 연결
        
    return answer
