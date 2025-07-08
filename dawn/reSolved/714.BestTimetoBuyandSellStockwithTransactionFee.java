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
        int sell =0;

        for(int price : prices){
            buy = Math.max(buy, sell-price);
            sell = Math.max(sell, buy+price-fee);
        }
        return sell;
    }
}

/***
 * 이 문제는 가장 쌀때 사고 가장 비쌀때 팔면서 이윤을 가장 크게 남기는 경우를 찾는 문제이다.
 *
 * 일단 사는 경우는 가격만큼 지불해야하기 때문에 맨 처음에는 -prices[0]로 초기화 시킨다.
 * 파는 경우는 맨 처음에는 안파니까 0으로 초기화 시킨다.
 * 가격에 따라서 사는경우와 파는 경우 건너뛰는 경우가 생긴다.
 * 사는 경우는 가장 쌀때사야하기 때문에 기존에 있는 buy와 sell-price를 해서 비교한다.
 * 파는 경우는 가장 비쌀때 팔아야하기 때문에 기존에 있는 sell과 팔았을때 남는 이윤이 buy+price-fee를 비교한다.
 * 이후 sell에 있는걸 반환하면 내가 팔고 남긴 이윤이 나오게 된다.
 */