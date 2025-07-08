/*
72. Edit Distance

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character

Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 */

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] result = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            result[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            result[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1];
                } else {
                    result[i][j] = 1 + Math.min(
                            result[i - 1][j - 1], Math.min(
                                    result[i][j - 1], result[i - 1][j]));
                }
            }
        }

        return result[m][n];
    }
}

/***
 * 이 문제는 word를 word2로 변경하는데 최소의 경우의 수로 변경하는 걸 묻는 문제이다.
 *
 * 일단 word1가 word2로 바뀔때 아무것도 없는 문자열이 word2로 바뀌어야한다면 한개씩 삽입이 되어야하기 때문에 i만큼으로 해주고, word2가 아무것도 없으면 삭제되어야하기 때문에 j만큼으로 해준다.
 * 그리고 for를 돌면서 확인하면 된다.
 * 같은 문자가 들어가 있으면 result[i][j]는 result[i-1][j-1]과 같아지게 된다.
 * 다른 문자가 들어가 있으면 이제 삽익, 삭제, 변경 중에 더 작은 값+1을 해주면 된다.
 * 이후 result[m][n]을 반환하면 된다.
 */