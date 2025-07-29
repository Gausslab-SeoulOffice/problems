/*
279. Perfect Squares

Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.


Example 1:
Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.

Example 2:
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 */

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;

        for(int i=1; i<=n; i++){
            for(int j =1; j*j<=i;j++){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}

/***
 * 이 문제는 n을 완전제곱수로 쪼갤 수 있는 최소의 수를 찾는 문제이다.
 *
 * 일단 0은 0이니까 dp[0]은 0으로 설정한다.
 * 그리고 dp[i-j*j]+1이 중요하다.
 * i에서 j*j를 뺀 수에서 j*j를 추가한거기 때문에 +1을 하는 것이다.
 * 13이라고 하면 j가 3이라고 가정하면 4를 만드는 숫자에서 3*3이라는 갯수를 그냥 추가한것이기 때문에 dp[4]+1이라는 것이다.
 * 이후 dp[n]을 반환하면 된다.
 */