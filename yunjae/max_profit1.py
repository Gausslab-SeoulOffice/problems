# LeetCode 121 - Best Time to Buy and Sell Stock
# 파이썬의 index 메소드를 활용했는데 시간복잡도상 큰 이득은 없습니다(O(n)). 
class Solution:
  def maxProfit(self, prices: List[int]) -> int:
    answer = 0
    min_p = min(prices)
    min_idx = prices.index(min_p) # 시간복잡도 O(n)

    if prices[min_idx:-1]:
      nearest_max_p = max(prices[min_idx:-1]) # 시간복잡도 O(n)
      answer = nearest_max_p - min_p
 
    return answer
