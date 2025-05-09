# LeetCode - Best Time to Buy and Sell Stock
# https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
# 우선 최저점을 구하고, 현재 값과의 차이를 계산한다. 이를 통해 최저점과 profit을 번갈아가면서 계속 갱신한다.

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
	    profit = 0
	    min_price = sys.maxsize

	    # 최솟값과 최댓값(= 현재 값 - 최솟값) 갱신
	    for price in prices:
		    min_price = min(min_price, price)
		    profit = max(profit, price - min_price)

	    return profit
