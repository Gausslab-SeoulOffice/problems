/*
121. Best Time to Buy and Sell Stock

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.


Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 */

class Solution {
    public int maxProfit(int[] prices) {
        int minNum = prices[0];
        int answer = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minNum) {
                minNum = prices[i];
            } else if (prices[i] - minNum > answer) {
                answer = prices[i] - minNum;
            }
        }
        return answer;
    }
}

/***
 * 이 문제는 최고의 이익을 내는 경우를 구하는 경우이다.
 *
 * 최소의 돈을 minNum이라고 선언하고, 결과를 answer로 선언한다.
 * 그리고 prices가 minNum보다 작으면 minNum를 업데이트한다.
 * 그게 아니라 파는게 더 좋다는 preices - minNum이 answer보다 크면 answer를 업데이트 한다.
 * 이후 answer를 반환하면 된다.
 */