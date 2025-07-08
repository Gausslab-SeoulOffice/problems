/*
338. Counting Bits

Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.


Example 1:
Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10

Example 2:
Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
 */

class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        if (n == 0) {
            return new int[] { 0 };
        }
        if (n == 1) {
            return new int[] { 0, 1 };
        }
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            int answer = 0;
            int j = i;
            while (j != 0) {
                if (j % 2 == 1) {
                    answer++;
                }
                j /= 2;
            }
            result[i] = answer;
        }
        return result;
    }
}

/***
 * 이 문제는 이진법으로 숫자를 표현해서 1이 들어간 갯수를 찾아내는 문제이다.
 *
 * 일단 0이랑 1을 기본적으로 해놓는다.
 * 2부터는 계산을 해야하는데 1이 들어가는 경우는 2로 나눴을때 1이 나머지로 나온다면 1이 추가 되는 형태이다.
 * 계산하기 위해서 answer을 선언해두고, j를 i로 하여 2로 나누면서 계산하게 된다.
 * 나머지가 1이 나오면 answer을 증가시키고 2로 나눠준다.
 * 이렇게 하다가 0이 되면 answer에 1의 갯수가 들어가 있기때문에 result[i]에 넣어준다.
 * 이후 result를 반환하면 된다.
 */