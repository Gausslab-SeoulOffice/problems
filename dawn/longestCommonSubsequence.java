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
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                }else{
                    result[i][j] = Math.max(result[i][j-1], result[i-1][j]);
                }
            }
        }
        return result[m][n];
    }
}

/***
 * 이 문제는 text1과 text2가 공통으로 가지고 있는 문자가 몇개가 있는지 묻는 문제이다.
 *
 * 각 단어마다 각 자리끼리 비교해야하기 때문에 2차원을 사용 할 것이다.
 * 각각 한개씩 가지고 와서 비교해야하기에 이중for문을 사용한다.
 * 현재 가지고 온 text1의 값과, 비교하면서 확인할 text2의 값이 있을 것이다.
 * 문자가 같으면 그 배열에 들어갈 값은 그 전에 있던 값보다 +1을 시키면 된다.
 * 그게 아니라면 위에 있거나 왼쪽에 있는 값에서 더 큰 값을 가지고 와서 지정해준다.
 * 그렇게 이동하면 mn에 최대의 숫자가 들어가 있다.
 */