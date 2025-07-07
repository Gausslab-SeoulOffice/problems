/*
746. Min Cost Climbing Stairs

You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.


Example 1:
Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.

Example 2:
Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.
 */

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length + 1];
        minCost[0] = 0;
        minCost[1] = 0;
        for (int i = 2; i < cost.length; i++) {
            minCost[i] = Math.min(minCost[i - 1] + cost[i - 1], minCost[i - 2] + cost[i - 2]);
        }
        return minCost[cost.length-1];
    }
}

/***
 * 이 문제는 계단을 올라갈때 최소한의 비용으로 올라갈 수 있는 경우를 찾으라는 문제이다.
 *
 * 일단 minCost라는 걸로 계단을 올라가는데 최소한의 비용을 담을 수 있는 배열을 만든다.
 * 인덱스 0이랑 1까지는 0의 비용으로 갈 수 있다.
 * 그리고 2인덱스부터는 계산을 해서 최소비용으로 저장해야한다.
 * 2까지 가기 위해서는 1까지 올 수 있는 최소비용, 1번째를 밟는 합과, 0까지 올 수 있는 최소비용, 0을 밟는 합 중 작은걸 선택하면 된다.
 * 그렇게 해서 제일 마지막 minCost를 반환하면 된다.
 */