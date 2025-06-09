/*
714. Best Time to Buy and Sell Stock with Transaction Fee

You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.

Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.

Note:

You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
The transaction fee is only charged once for each stock purchase and sale.


Example 1:
Input: prices = [1,3,2,8,4,9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
- Buying at prices[0] = 1
- Selling at prices[3] = 8
- Buying at prices[4] = 4
- Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

Example 2:
Input: prices = [1,3,7,5,10,3], fee = 3
Output: 6
 */

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buy = -prices[0];
        int sell = 0;

        for (int price : prices) {
            buy = Math.max(buy, sell - price);
            sell = Math.max(sell, buy + price - fee);
        }
        return sell;
    }
}

/***
 * 이 문제는 주식을 사고파는것에 있어서 최대 이익을 남기도록 하는 문제이다.
 * 팔때는 수수료 fee가 붙는 것이 특징이다.
 *
 * 일단 처음에 사게 되는 경우와 가만히 있는 경우를 세팅한다.
 * 사게 된다면 prices[0]만큼 마이너스가 되는것이고, 처음에 아무것도 안하면 0이다.
 * 그리고 가격만큼 확인을 하면 된다.
 * 다음 가격으로 넘어가서 그걸 사는 경우엔 사는경우 vs 그대로 있는 경우 중 더 큰 경우를 고른다.
 * 파는 경우엔 오늘 파는 경우 vs 그대로 있는 경우 중 더 큰 경우를 고른다.
 * 마지막엔 파는 것이 좋기때문에 sell을 반환한다.
 */