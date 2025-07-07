/*
790. Domino and Tromino Tiling

You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.


Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large, return it modulo 109 + 7.

In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.


Example 1:
Input: n = 3
Output: 5
Explanation: The five different ways are shown above.

Example 2:
Input: n = 1
Output: 1
 */

class Solution {
    public int numTilings(int n) {
        int mod = 1000000007;
        long[] ways = new long[n + 1];
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 5;
        ways[1] = 1;
        ways[2] = 2;
        ways[3] = 5;
        for (int i = 4; i <= n; i++) {
            ways[i] = (2 * ways[i - 1] + ways[i - 3]) % mod;
        }
        return (int)ways[n];
    }
}

/***
 * 이 문제는 타일이 있고 n이 주어질때 만들 수 있는 모양이 몇개가 되는지 구하는 문제이다.
 *
 * 일단 2개짜리 타일이랑 3개짜리 타일로 만들 수 있는게 정해진건 1,2,3까지이기 때문에 미리 저장해둔다.
 * 그리고 4부터는 경우의수를 모두 더해주어야한다.
 * 일단 i-1로 구할 수 있는건 2개짜리 타일을 오른쪽에 두는 방법과 왼쪽에 두는 방법이 2가지 있기 때문에 2를 곱해준다.
 * 그리고 3개짜리를 이용하는 방법이 있기때문에 i-3의 방법을 더해준다.
 * 이후 ways를 반환하면 된다.
 */