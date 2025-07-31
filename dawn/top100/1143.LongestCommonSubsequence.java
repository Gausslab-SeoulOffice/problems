/*
1143. Longest Common Subsequence

Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.


Example 1:
Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.

Example 2:
Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.

Example 3:
Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 */

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] result = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
            }
        }
        return result[m][n];
    }
}

/***
 * 이 문제는 text1과 text2가 주어졌을때 가장 긴 공통의 부분문자열의 길이을 구하는 문제이다.
 *
 * m에서 n까지 문자를 비교하면서 길이를 넣으면 된다.
 * 지금 있는 위치인 i, j에서 -1위치 문자열이 같다면 result[i][j]는 resut[i-1][j-1]에 있던 값에 +1을 해주면 된다.
 * 그게 아니라면 더 큰 값을 가지고 와야한다.
 * result[i-1][j]나 result[i][j-1]에 있는 값 중 더 큰 값을 가지고 와서 result[i][j]에 지정해주면 된다.
 * 이후 반복문을 다 돌리고 result[m][n]을 반환하면 된다.
 */