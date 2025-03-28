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
        result[1] =1;
        result[2]= 2;
        for(int i =3;i<=n;i++){
            result[i] = result[i-1]+result[i-2];
        }
        return result[result.length-1];
    }
}

/***
 * 이 문제는 계단을 올라가는 방법이 몇가지 인지 물어보는 문제이다.
 * 계단은 1,2칸만 올라갈 수 있다.
 *
 * 생각해보면
 * f(n) = f(n-1) + f(n-2)
 * n-1에서 1칸 오르는 경우
 * n-2에서 2칸 오르는 경우
 * i칸까지 오를 수 있는 방법 =
 * → i-1칸에서 1칸 오르기
 * i-2칸에서 2칸 오르기
 */