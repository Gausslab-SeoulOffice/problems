# 프로그래머스 - 라면 공장
# 
# 1. 문제 요약
# 
# 공장은 하루에 밀가루 1톤이 필요합니다.
# 기존 공급 공장의 문제로 k일동안 해외에서 수입해야합니다.
# 해외 공장에서 공급 날짜와 수량을 알려주고, 최소한의 횟수로 밀가루를 공급받고자 합니다.
# stock : 현재 남은 밀가루
# dates : 밀가루 공급 일정
# supplies : 일정당 공급 가능 수량
# k : 기존 공급 공장이 공급 가능해지는 시점
# 최소 몇 번 해외로부터 수입해야하는지를 return하는 문제입니다.
# 
# 2. 제한 사항
# 
# stock의 밀가루는 0일 이후부터 사용합니다.
# k일 째에는 밀가루가 충분히 공급되기 때문에 k-1일에 사용할 수량까지만 확보하면 됩니다.
# dates는 오름차순 정렬되어 있습니다. 작업 시작 전에 공급을 기준으로 합니다.
# 바닥나는 경우는 없습니다.
# 
# 3. 테스트 케이스
# stock: 4
# dates: [4, 10, 15]
# supplies: [20, 5, 10]
# k:30
# result: 2

# 이 문제에서는 최대힙을 써야 한다.
# 일단 들어오면 어떻게든 k일까지 재고를 유지해야 하기 때문.
# 파이썬에서 최대힙을 쓰려면 최소힙인 heapq에 부호 반전하면 된다

import heapq

def solution(stock, dates, supplies, k):
  result = 0

  pq = []
  while stock < k:                 # 하루 밀가루 1톤이므로, 둘은 서로 비교 가능
    for i in range(len(dates)):
      if dates[i] <= stock:
        heapq.heappush(pq, -supplies[i])
    stock += -heapq.heappop(pq)
    result += 1
  
  return result
