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
        if (n == 0)
            return new int[] { 0 };
        if (n == 1)
            return new int[] { 0, 1 };
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
 * 이문제는 n만큼의 숫자를 0부터 시작해서 이진수롤 변환했을 때 각숫자에 1이 얼만큼 들어가는지 확인해서 배열로 반환하라는 문제이다.
 *
 * 크기가 n+1인 배열 result를 만들어서 0 ~ n의 값을 담을 준비를 한다.
 * i라는 숫자를 이진수로 바꾸어, 1의 개수를 직접 계산하는 방식이다.
 * 나눗셈(j /= 2)과 나머지(j % 2)를 통해 숫자를 이진수로 쪼개면서 1이 나올 때마다 answer++한다.
 * 이후 배열에 등록해서 result를 반환한다.
 */