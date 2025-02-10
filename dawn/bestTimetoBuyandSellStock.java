/*
 * 121. Best Time to Buy and Sell Stock
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
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
 * 문제는 설명에서 좀 이해를 잘못한 부분이 있어서 한 번 틀렸다.ㅎ
 * 일단 주식이라 생각하면 된다. 날마다 가격이 나오는거고 가장 싸게 사서 팔아서 이윤을 output하면 되는거다.
 * 예시를 보면 쉽다. [7, 1, 5, 3, 6, 4] 이렇게 나면 1원에 사서 6원에 팔면 5원의 수익이 남는것이다.
 * 두 번째 예시에서 잘못 이해한 부분이 나온다. [7, 6, 4, 3, 1] 이렇게 나오면 그냥 제일 작은 수가 맨 뒤에 있으면 0을 출력하라고 생각해버렸다.
 * 사실 [2, 4, 1]이렇게 나오면 2원에 사서 4원에 팔면 2원이라는 값이 나오는건데 말이다.
 * 일단 minNum을 업데이트 하는 방식은 동일하다. 그치만 prices[i] < minNum이 아니고, 그 전 이윤보다 값이 크다면 그걸로 업데이트 해주는 방식이다.
 */