/*
70. Climbing Stairs

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 */

class Solution {
    public int climbStairs(int n) {
        int[] result = new int[n+1];
        if(n<2){
            return n;
        }
        result[1]=1;
        result[2]=2;

        for(int i=3; i<=n; i++){
            result[i] = result[i-1]+result[i-2];
        }
        return result[n];
    }
}

/***
 * 이 문제는 계단을 올라가는 경우의 수를 모두 찾는 문제이다.
 *
 * 이건 그냥 result[i]은 result[i-1]+result[i-2]를 하면 된다.
 * 일단 n이 1인 경우나 2인 경우에는 답이 정해져 있다.
 * for문을 돌릴때 n까지 해야하기 때문에 n을 포함해서 돌리고, 반환할때 result[n]을 반환하면 된다.
 */