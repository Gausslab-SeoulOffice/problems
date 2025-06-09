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
        for (int i = 2; i <= cost.length; i++) {
            minCost[i] = Math.min(cost[i - 1] + minCost[i - 1], cost[i - 2] + minCost[i - 2]);
        }
        return minCost[cost.length];
    }
}

/***
 * 이 문제는 모든 계단을 올라갈때 최소의 비용으로 올라가는 걸 반환하는 문제이다.
 *
 * 일단 맨처음에 0번째칸과 1번째칸을 올라갈 수 있다.
 * 그렇기에 minCost[0]과 minCost[1]은 0으로 세팅한다.
 * 그리고 2번째 칸부터 올라가는걸 계산해야하는데 최소의 비용으로 올라가는걸 계산해야한다.
 * 갈 수 있는 방법은 두가지가 있다.
 * 이전 계단까지 올라오는 최소의 비용+이전 계단의 비용과 이전전 계단까지 올라오는 최소의 비용+이전전 계단의 비용을 비교해서 더 작은걸 선택한다.
 * 그렇게 되면 cost.length의 계단이 마지막 계단이기 때문에 반환은 mincost[cost.length]의 값을 하면된다.
 */