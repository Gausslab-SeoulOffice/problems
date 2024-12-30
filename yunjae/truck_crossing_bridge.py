from collections import deque

def solution(bridge_length, weight, truck_weights):
    # 다리를 다 지난 트럭은 굳이 별도로 저장할 필요 없음
    bridge_weights = deque([0]*bridge_length)
    truck_weights = deque(truck_weights)
    # 다리를 큐로 만듬. 0으로 가득찬 큐를 한칸씩 밀어낼것.
    # 여기서 0을 하나씩 빼다 보면 굳이 bridge_length를 마지막에 answer와 더해주지 않아도 된다.
    answer = 0
    passing_sum = sum(bridge_weights) # 비어있는 다리의 하중
    
    while bridge_weights: # 다리에 트럭이 없을 때까지
        answer += 1 # 1초씩 이동
        passing_sum -= bridge_weights.popleft() # 다리를 빠져나가게 함. 하중도 감소한다. 0을 빼면 0만큼만 감소하니 음수가 되는 일은 없다.
        
        if truck_weights: # 대기열에 트럭이 남아있다면
            if passing_sum + truck_weights[0] <= weight: # 만약 다리 위에 올렸을 경우 하중 초과나 길이 초과에 걸리지 않는지 확인한다
                t = truck_weights.popleft()
                bridge_weights.append(t) # 문제 없다면 다리에 올린다
                passing_sum += t # 그만큼 하중도 올라간다
            else:
                bridge_weights.append(0) # 문제 있다면 그냥 차가 다리를 건너게끔 0을 push한다
                
    return answer
