# LeetCode 122 - Best Time to Buy and Sell Stock II
class Solution:
  def maxProfit(self, prices: List[int]) -> int:
    answer = 0
  
    # 처음 풀이: 부분합을 누적시킨다는 점에서 맞는다
    # for i in range(1, len(prices)):
    #  if prices[i-1] < prices[i]:
    #    answer += prices[i] - prices[i-1]

    # 둘째 풀이: 사는 가격과 파는 가격을 좀더 엄밀하게 구분한다
    # (이 풀이를 바로 떠올리긴 어려웠습니다. 주식 거래에 대한 감각이 있었더라면...)
    buy = prices[0] # 최초에 산 가격
    for i in range(1, len(prices)): # 바로 그 다음 시점 가격부터 훑어본다
      if prices[i] > buy: # 지금 가격을 보아하니 파는 게 이득일 때
        answer += prices[i] - buy # 일단 처분하고
        buy = prices[i] # 그 가격으로 또 산다(산 가격을 갱신)
      else: # 팔면 손해일 때 (여기서는 prices[i] < buy)
        buy = min(prices[i], buy) # 가급적 저가로 매수
      
    return answer
