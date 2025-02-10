/*
 *
 *122. Best Time to Buy and Sell Stock II
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
 * Find and return the maximum profit you can achieve.
 *
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 *
 * Example 2:
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Total profit is 4.
 *
 * Example 3:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 */

class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]){
                answer = answer + prices[i]-prices[i-1];
            }
        }
        return answer;
    }
}

/***
 * 이 문제는 이해는 쉬웠다. 저번이랑 거의 비슷한 유형이다. 최대의 이익을 내는 건데, 추가 된게 있다면 사고 팔고 여러번 할 수 있고, 그 과정에서 최대의 이익을 return하라는 것이다.
 * 여기서 유념하게 있다. [1, 5, 100]이렇게 있다고 가정해보자. 그럼 (5 - 1) + (100 - 5) => 4 + 95 => 99 이렇게 되는건데 100 - 1 과도 같은걸 확인할 수 있다.
 * 그냥 중간에 큰 수가 있다고 하더라도 그 사이에서 증가하는건 똑같기 때문에 값이 동일하다는 것이다.
 * 그렇다면 [1, 5, 3, 100]이렇게 된다면 좀 달라질 것이다. (5 - 1) + (100 - 3) => 4 + 97 =>101 이렇게 중간에 작은 수가 나오게 된다면 이야기가 좀 달라진다.
 * 일단 이익을 다 더한건 answer이라는 변수 안에 들어갈 것이고,
 * 현재 수가 그 전수보다 크면 무조건 팔아서 이익을 남기고 작으면 그걸로 다시 살거니까 넘어가면 된다.
 */