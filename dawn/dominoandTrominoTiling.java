/*
790. Domino and Tromino Tiling

ou have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.

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
        int MOD = 1_000_000_007;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 5;
        long[] result = new long[n + 1];

        result[0] = 1;
        result[1] = 1;
        result[2] = 2;
        result[3] = 5;
        for (int i = 4; i <= n; i++) {
            result[i] = (2 * result[i - 1] + result[i - 3])%MOD;
        }
        return (int)result[n];
    }
}

/***
 * 이 문제는 모양이 2개인 퍼즐이 존재하는데 2xn이 주어질때 만들 수 있는 모양의 갯수를 반환하라는 문제이다.
 *
 * 일단 접근은 쉬웠는데 MOD를 생각못한 부분도 있었다.
 * 일단 n이 1이면 무조건 1개로만 만들 수 있다.
 * n이 2이면 무조건 2가지 경우의 수가 나온다.
 * n이 3이면 무조건 5가지 경우의 수가 나온다.
 * 이를 토대로 만드는 경우의 수를 찾으면 되는데 도화식을 찾는데 생각을 해야한다.
 * 4부터는 3보다 한줄이 늘어나는 경우다.
 * 한줄이 늘어나면 만들수 있는 방법이 정해진다.
 * 오른쪽이나 왼쪽에 2X1짜리를 추가하는 방법이 있다.
 * 그렇기 때문에 result[n-1]에 2를 곱해야한다.
 * 그리고 추가로 방법이 또 있다.
 * Tromino 퍼즐을 사용하는데 이걸 사용하는 방법은 3줄이 필요하기 때문에 result[i-3]의 만들어지는 경우의 수를 더해주면 된다.
 * 여기서 숫자가 너무 커지면 int의 범위를 넘어가기때문에 mod를 설정해서 나눠줘야하고, result의 경우 long이지만 return 값은 int가 되어야하기에 형변환을 하고 반환해야한다.
 */